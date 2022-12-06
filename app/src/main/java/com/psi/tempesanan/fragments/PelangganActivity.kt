package com.psi.tempesanan.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.psi.tempesanan.R
import kotlinx.android.synthetic.main.activity_edit_pelanggan.*

class PelangganActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelanggan)
    }

    fun setupListener() {
        button_create_pelanggan.setOnClickListener{
            startActivity(Intent(this, EditPelangganActivity::class.java))
        }
    }
}