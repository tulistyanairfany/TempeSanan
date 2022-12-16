package com.psi.tempesanan.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.db.TempeDao
import com.psi.tempesanan.fragments.db.TempeRoomDatabase
import com.psi.tempesanan.fragments.model.Tempe
import kotlinx.android.synthetic.main.activity_edit_produk.*

class EditProdukActivity : AppCompatActivity() {

    val EDIT_PRODUK_EXTRA = "edit_produk_extra"
    private lateinit var tempe: Tempe
    private var isUpdate = false
    private lateinit var database: TempeRoomDatabase
    private lateinit var dao: TempeDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_produk)

        database = TempeRoomDatabase.getDatabase(applicationContext)
        dao = database.getTempeDao()

        if (intent.getParcelableExtra<Tempe>(EDIT_PRODUK_EXTRA) != null){
            button_hapus_produk.visibility = View.VISIBLE
            isUpdate = true
            tempe = intent.getParcelableExtra(EDIT_PRODUK_EXTRA)!!
            edit_namaproduk.setText(tempe.namabarang)
            edit_hargaproduk.setText(tempe.hargabarang)

            edit_namaproduk.setSelection(tempe.namabarang.length)

        }

        button_save_produk.setOnClickListener {
            val namabarang = edit_namaproduk.text.toString()
            val hargabarang = edit_hargaproduk.text.toString()

            if (namabarang.isEmpty() && hargabarang.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Kamu Belum Memasukkan Nama Barang",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (isUpdate) {
                    saveProduk(
                        Tempe(
                            id = tempe.id,
                            namabarang = namabarang,
                            hargabarang = hargabarang
                        )
                    )
                } else {
                    saveProduk(Tempe(namabarang = namabarang, hargabarang = hargabarang))
                }
            }
            finish()

        }

    }

    private fun saveProduk(tempe: Tempe) {
        if (dao.getById(tempe.id).isEmpty()){

            dao.insert(tempe)
        }
        else{
            dao.update(tempe)
        }
        Toast.makeText(applicationContext, "BERHASIL DISIMPAN", Toast.LENGTH_SHORT).show()
    }

    private fun deleteProduk(tempe: Tempe){
        dao.delete(tempe)
        Toast.makeText(applicationContext, "BERHASIL DIHAPUS", Toast.LENGTH_SHORT).show()
    }
}
