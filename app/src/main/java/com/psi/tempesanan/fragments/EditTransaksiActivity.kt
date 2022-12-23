package com.psi.tempesanan.fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.db.PelangganDao
import com.psi.tempesanan.fragments.db.TempeRoomDatabase
import com.psi.tempesanan.fragments.db.TransaksiDao
import com.psi.tempesanan.fragments.model.Pelanggan
import com.psi.tempesanan.fragments.model.Transaksi
import kotlinx.android.synthetic.main.activity_edit_pelanggan.*
import kotlinx.android.synthetic.main.activity_edit_transaksi.*
import kotlinx.android.synthetic.main.activity_transaksi.*
import java.util.*


class EditTransaksiActivity : AppCompatActivity() {

    val EDIT_TRANSAKSI_EXTRA = "edit_transaksi_extra"
    private lateinit var transaksi: Transaksi
    private var isUpdate = false
    private lateinit var database: TempeRoomDatabase
    private lateinit var dao: TransaksiDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_transaksi)

        database = TempeRoomDatabase.getDatabase(applicationContext)
        dao = database.getTransaksiDao()

        val mPilih = findViewById<TextView>(R.id.txtview_listbarang)

        btn_pilih_barang.setOnClickListener {
            val builder = AlertDialog.Builder(this@EditTransaksiActivity)
            val colorsArray = arrayOf("Original 100gr",
                "Original 220gr",
                "Pedas Manis 100gr",
                "Pedas Manis 220gr",
                "Keju 100gr",
                "Keju 220gr",
                "Pizza 100gr",
                "Pizza 220gr",
                "Barbeque 100gr",
                "Barbeque 220gr",
                "Udang 100gr",
                "Udang 220gr",
                "Balado 100gr",
                "Balado 220gr",
                "Spaghetti 100gr",
                "Spaghetti 220gr",
                "Jagung Manis 100gr",
                "Jagung Manis 220gr",
                "Ayam Lada Hitam 100gr",
                "Ayam Lada Hitam 220gr",
                "Sambal Setan 100gr",
                "Sambal Setan 220gr")
            val checkedColorsArray = booleanArrayOf(
                false,
                false, // Orange
                false, // Green
                false, // Yellow checked
                false, // White
                false, //Purple
                false,
                false, // Orange
                false, // Green
                false, // Yellow checked
                false, // White
                false,
                false,
                false, // Orange
                false, // Green
                false, // Yellow checked
                false, // White
                false,
                false,
                false, // Orange
                false, // Green
                false, // Yellow checked
                false, // White

            )
            val colorsList = Arrays.asList(*colorsArray)
            builder.setTitle("Pilih Produk")
            builder.setMultiChoiceItems(colorsArray, checkedColorsArray) { dialog, which, isChecked ->
                checkedColorsArray[which] = isChecked
                val currentItem = colorsList[which]
                Toast.makeText(applicationContext, currentItem + " " + isChecked, Toast.LENGTH_SHORT).show()
            }
            builder.setPositiveButton("Pilih") { dialog, which ->
                "Produk : " .also { mPilih.text = it }
                for (i in checkedColorsArray.indices) {
                    val checked = checkedColorsArray[i]
                    if (checked) {
                        (mPilih.text.toString() + colorsList[i] + " , ").also { mPilih.text = it }
                    }
                }
            }
            builder.setNeutralButton("Batal") { dialog, which ->
            }
            val dialog = builder.create()
            dialog.show()
        }

        //Kalender
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        //Button Klik Kalender
        pilih_tanggal.setOnClickListener{
            val dpd = DatePickerDialog(this,  DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                //date
                edit_tgltransaksi.setText("" + mDay + "/" + mMonth + "/" + mYear)
            }, year,month,day)
            dpd.show()
        }


        if (intent.getParcelableExtra<Transaksi>(EDIT_TRANSAKSI_EXTRA) != null){
            button_hapus_transaksi.visibility = View.VISIBLE
            isUpdate = true
            transaksi = intent.getParcelableExtra(EDIT_TRANSAKSI_EXTRA)!!
            edit_tgltransaksi.setText(transaksi.tanggaltrans)
            spinner2.setSelection(transaksi.namapelanggantrans.length)
            txtview_listbarang.setText(transaksi.namabarangtrans)
            edit_transaksitotal.setText(transaksi.hargabarangtrans)
        }
        button_save_transaksi.setOnClickListener {

            val tanggaltrans = edit_tgltransaksi.text.toString()
            val namapelanggantrans = spinner2.selectedItem.toString()
            val namabarangtrans = txtview_listbarang.text.toString()
            val hargabarangtrans = edit_transaksitotal.text.toString()

            if (tanggaltrans.isEmpty() && namapelanggantrans.isEmpty() && namabarangtrans.isEmpty() && hargabarangtrans.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Data yang Anda masukkan tidak lengkap",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (isUpdate) {
                    saveTransaksi(
                        Transaksi(
                            id_transaksi = transaksi.id_transaksi,
                            tanggaltrans = tanggaltrans,
                            namapelanggantrans = namapelanggantrans,
                            namabarangtrans = namabarangtrans,
                            hargabarangtrans = hargabarangtrans
                        )
                    )
                }
                else {
                    saveTransaksi(Transaksi(tanggaltrans = tanggaltrans, namapelanggantrans = namapelanggantrans, namabarangtrans = namabarangtrans, hargabarangtrans = hargabarangtrans))
        }
            }
            finish()
        }
        button_hapus_transaksi.setOnClickListener {
            deleteTransaksi(transaksi)
            finish()
        }

    }


    private fun saveTransaksi(transaksi: Transaksi) {

        if (dao.getById(transaksi.id).isEmpty()){
            dao.insert(transaksi)
        }
        else{
            dao.update(transaksi)
        }
        Toast.makeText(applicationContext, "BERHASIL DISIMPAN", Toast.LENGTH_SHORT).show()
    }

    private fun deleteTransaksi(transaksi: Transaksi){
        dao.delete(transaksi)
        Toast.makeText(applicationContext, "BERHASIL DIHAPUS", Toast.LENGTH_SHORT).show()
    }

}
