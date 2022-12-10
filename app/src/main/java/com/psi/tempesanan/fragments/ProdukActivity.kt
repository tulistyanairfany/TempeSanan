package com.psi.tempesanan.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.room.Constant
import com.psi.tempesanan.fragments.room.Tempe
import com.psi.tempesanan.fragments.room.TempeDB
import kotlinx.android.synthetic.main.activity_produk.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProdukActivity : AppCompatActivity(), View.OnClickListener {

    private val db by lazy { TempeDB(this) }
    lateinit var tempeAdapter: TempeAdapter

    private lateinit var btnIntent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk)

        btnIntent = findViewById(R.id.button_create_produk)
        btnIntent.setOnClickListener(this)
        setupView()
        setupListener()
        setupRecyclerView()

    }
    override fun onResume() {
        super.onResume()
        loadData()
    }
    private fun loadData(){
        CoroutineScope(Dispatchers.IO).launch {
            tempeAdapter.setData(db.TempeDao().getTempes())
            withContext(Dispatchers.Main) {
                tempeAdapter.notifyDataSetChanged()
            }
        }
    }
    private fun setupView (){
        supportActionBar!!.apply {
            title = "Catatan"
        }
    }

    private fun setupListener(){
        button_create_produk.setOnClickListener {
            intentEdit(Constant.TYPE_CREATE, 0)
        }
    }

    private fun setupRecyclerView () {

        tempeAdapter = TempeAdapter(
            arrayListOf(),
            object : TempeAdapter.OnAdapterListener {
                override fun onClick(tempe: Tempe) {
                    intentEdit(Constant.TYPE_READ, tempe.id)
                }

                override fun onUpdate(tempe: Tempe) {
                    intentEdit(Constant.TYPE_UPDATE, tempe.id)
                }

                override fun onDelete(tempe: Tempe) {
                    deleteAlert(tempe)
                }

            })

        list_produk.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = tempeAdapter
        }

    }
    private fun intentEdit(intent_type: Int, tempe_id: Int) {
        startActivity(
            Intent(this, EditProdukActivity::class.java)
                .putExtra("intent_type", intent_type)
                .putExtra("tempe_id", tempe_id)
        )

    }

    private fun deleteAlert(tempe: Tempe){
        val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("Konfirmasi Hapus")
            setMessage("Yakin hapus ${tempe.namabarang}?")
            setNegativeButton("Batal") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            setPositiveButton("Hapus") { dialogInterface, i ->
                CoroutineScope(Dispatchers.IO).launch {
                    db.TempeDao().deleteTempe(tempe)
                    dialogInterface.dismiss()
                    loadData()
                }
            }
        }

        dialog.show()
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.button_create_produk -> run {
                    val intentBiasa = Intent(this@ProdukActivity, EditProdukActivity::class.java)
                    startActivity(intentBiasa)
                }
            }
        }
    }
}