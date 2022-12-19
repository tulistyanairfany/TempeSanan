package com.psi.tempesanan.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.db.PelangganDao
import com.psi.tempesanan.fragments.db.TempeDao
import com.psi.tempesanan.fragments.db.TempeRoomDatabase
import com.psi.tempesanan.fragments.model.Pelanggan
import kotlinx.android.synthetic.main.activity_edit_pelanggan.*
import kotlinx.android.synthetic.main.activity_edit_produk.*

class EditPelangganActivity : AppCompatActivity() {

    val EDIT_PELANGGAN_EXTRA = "edit_pelanggan_extra"
    private lateinit var pelanggan: Pelanggan
    private var isUpdate = false
    private lateinit var database: TempeRoomDatabase
    private lateinit var dao: PelangganDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_pelanggan)

        database = TempeRoomDatabase.getDatabase(applicationContext)
        dao = database.getPelangganDao()

        if (intent.getParcelableExtra<Pelanggan>(EDIT_PELANGGAN_EXTRA) != null){
            button_hapus_pelanggan.visibility = View.VISIBLE
            isUpdate = true
            pelanggan = intent.getParcelableExtra(EDIT_PELANGGAN_EXTRA)!!
            edit_namapelanggan.setText(pelanggan.namapelanggan)
            edit_nomortelp.setText(pelanggan.nomortelp)

            edit_namapelanggan.setSelection(pelanggan.namapelanggan.length)

        }
        button_save_pelanggan.setOnClickListener {
            val namapelanggan = edit_namapelanggan.text.toString()
            val nomortelp = edit_nomortelp.text.toString()

            if (namapelanggan.isEmpty() && nomortelp.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Kamu Belum Memasukkan Nama Pelanggan",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (isUpdate) {
                    savePelanggan(
                        Pelanggan(
                            id = pelanggan.id,
                            namapelanggan = namapelanggan,
                            nomortelp = nomortelp
                        )
                    )
                } else {
                    savePelanggan(Pelanggan(namapelanggan = namapelanggan, nomortelp = nomortelp))
                }
            }
            finish()

        }
        button_hapus_pelanggan.setOnClickListener {
            deletePelanggan(pelanggan)
            finish()
        }
    }
    private fun savePelanggan(pelanggan: Pelanggan) {
        if (dao.getById(pelanggan.id).isEmpty()){

            dao.insert(pelanggan)
        }
        else{
            dao.update(pelanggan)
        }
        Toast.makeText(applicationContext, "BERHASIL DISIMPAN", Toast.LENGTH_SHORT).show()
    }

    private fun deletePelanggan(pelanggan: Pelanggan){
        dao.delete(pelanggan)
        Toast.makeText(applicationContext, "BERHASIL DIHAPUS", Toast.LENGTH_SHORT).show()
    }

}