package com.psi.tempesanan.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.psi.tempesanan.R

class ProdukActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk)

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
}