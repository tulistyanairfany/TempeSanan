package com.psi.tempesanan.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.db.TempeRoomDatabase
import com.psi.tempesanan.fragments.model.Pelanggan
import com.psi.tempesanan.fragments.model.Tempe
import kotlinx.android.synthetic.main.activity_edit_pelanggan.*
import kotlinx.android.synthetic.main.activity_pelanggan.*
import kotlinx.android.synthetic.main.activity_produk.*

class PelangganActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelanggan)

        getTabelPelangganData()

        btnIntent = findViewById(R.id.button_create_pelanggan)
        btnIntent.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.button_create_pelanggan -> run {
                    val intentBiasa = Intent(this@PelangganActivity, EditPelangganActivity::class.java)
                    startActivity(intentBiasa)
                }
            }
        }
    }
//
    private fun getTabelPelangganData() {
        val database = TempeRoomDatabase.getDatabase(applicationContext)
        val dao = database.getPelangganDao()
        val listItems = arrayListOf<Pelanggan>()
        listItems.addAll(dao.getAll())
        setupRecycleView(listItems)
        if (listItems.isNotEmpty()){
            text_view_pelanggan_empty.visibility = View.GONE
        }
        else {
            text_view_pelanggan_empty.visibility = View.VISIBLE
        }
    }

    private fun setupRecycleView(listItems: ArrayList<Pelanggan>) {
        recycler_view_pelanggan.apply {
            adapter = PelangganAdapter(listItems, object : PelangganAdapter.PelangganListener{
                override fun OnItemClicked(pelanggan: Pelanggan) {
                    val intent = Intent(this@PelangganActivity, EditPelangganActivity::class.java)
                    intent.putExtra(EditPelangganActivity(). EDIT_PELANGGAN_EXTRA, pelanggan)
                    startActivity(intent)
                }

            })

            layoutManager = LinearLayoutManager(this@PelangganActivity)
        }
    }



    override fun onResume() {
        super.onResume()
        getTabelPelangganData()
    }
}