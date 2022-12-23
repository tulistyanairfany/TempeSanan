package com.psi.tempesanan.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.db.TempeRoomDatabase
import com.psi.tempesanan.fragments.model.Transaksi
import kotlinx.android.synthetic.main.activity_transaksi.*

class TransaksiActivity : AppCompatActivity(), View.OnClickListener {

     private lateinit var btnIntent : Button

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi)

         getTabelTransaksiData()

         btnIntent = findViewById(R.id.button_create_transaksi)
         btnIntent.setOnClickListener(this)

     }
    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.button_create_transaksi -> run {
                    val intentBiasa = Intent(this@TransaksiActivity, EditTransaksiActivity::class.java)
                    startActivity(intentBiasa)
                }
            }
        }
    }

    private fun getTabelTransaksiData() {
        val database = TempeRoomDatabase.getDatabase(applicationContext)
        val dao = database.getTransaksiDao()
        val listItems = arrayListOf<Transaksi>()
        listItems.addAll(dao.getAll())
        setupRecycleView(listItems)
        if (listItems.isNotEmpty()){
            text_view_transaksi_empty.visibility = View.GONE
        }
        else {
            text_view_transaksi_empty.visibility = View.VISIBLE
        }
    }

    private fun setupRecycleView(listItems: ArrayList<Transaksi>) {
        list_transaksi.apply {
            adapter = TransaksiAdapter(listItems, object : TransaksiAdapter.TransaksiListener{
                override fun OnItemClicked(transaksi: Transaksi) {
                    val intent = Intent(this@TransaksiActivity, EditTransaksiActivity::class.java)
                    intent.putExtra(EditTransaksiActivity(). EDIT_TRANSAKSI_EXTRA, transaksi)
                    startActivity(intent)
                }

            })

            layoutManager = LinearLayoutManager(this@TransaksiActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        getTabelTransaksiData()
    }


}



