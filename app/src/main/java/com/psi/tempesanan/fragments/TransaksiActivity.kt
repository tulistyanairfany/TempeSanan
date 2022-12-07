package com.psi.tempesanan.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.EditTransaksiActivity as TempesananFragmentsEditTransaksiActivity


class TransaksiActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var btnIntent : Button

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi)

         btnIntent = findViewById(R.id.button_create_transaksi)
         btnIntent.setOnClickListener(this)

     }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.button_create_transaksi -> run {
                    val intentBiasa = Intent(this@TransaksiActivity, TempesananFragmentsEditTransaksiActivity::class.java)
                    startActivity(intentBiasa)
                }
            }
        }
    }
}



