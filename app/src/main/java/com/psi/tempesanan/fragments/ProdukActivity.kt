package com.psi.tempesanan.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.SearchView
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.db.TempeRoomDatabase
import com.psi.tempesanan.fragments.model.Tempe
import kotlinx.android.synthetic.main.activity_produk.*

class ProdukActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk)

        getTabelProdukData()

        btnIntent = findViewById(R.id.button_create_produk)
        btnIntent.setOnClickListener(this)

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

    private fun getTabelProdukData() {
        val database = TempeRoomDatabase.getDatabase(applicationContext)
        val dao = database.getTempeDao()
        val listItems = arrayListOf<Tempe>()
        listItems.addAll(dao.getAll())
        setupRecycleView(listItems)
        if (listItems.isNotEmpty()){
            text_view_produk_empty.visibility = View.GONE
        }
        else {
            text_view_produk_empty.visibility = View.VISIBLE
        }
    }
    private  fun setupRecycleView(listItems : ArrayList<Tempe>) {
        recycler_view_main.apply {
            adapter = ProdukAdapter(listItems, object : ProdukAdapter.TempeListener{
                override fun OnItemClicked(tempe: Tempe) {
                    val intent = Intent(this@ProdukActivity, EditProdukActivity::class.java)
                    intent.putExtra(EditProdukActivity(). EDIT_PRODUK_EXTRA, tempe)
                    startActivity(intent)
                }

            })

            layoutManager = LinearLayoutManager(this@ProdukActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        getTabelProdukData()
    }
}