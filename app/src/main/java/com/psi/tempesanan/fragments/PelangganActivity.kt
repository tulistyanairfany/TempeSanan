package com.psi.tempesanan.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.psi.tempesanan.R
import kotlinx.android.synthetic.main.activity_edit_pelanggan.*

class PelangganActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelanggan)

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

}