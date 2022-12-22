package com.psi.tempesanan.fragments

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.psi.tempesanan.R
import kotlinx.android.synthetic.main.activity_edit_transaksi.*
import java.util.*

class EditTransaksiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_transaksi)


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
    }
    }