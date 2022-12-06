package com.psi.tempesanan.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.psi.tempesanan.R
import kotlinx.android.synthetic.main.activity_edit_pelanggan.*
import kotlinx.android.synthetic.main.activity_edit_transaksi.*
import kotlinx.android.synthetic.main.activity_transaksi.*
import kotlinx.android.synthetic.main.activity_edit_transaksi.button_create_transaksi as button_create_transaksi1


class TransaksiActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi)

         val btntbh: Button = findViewById(R.id.button_create_transaksi)

         btntbh.setOnClickListener{
             val intent = Intent(this, EditTransaksiActivity::class.java)
             startActivity(intent)
         }

    }
}
