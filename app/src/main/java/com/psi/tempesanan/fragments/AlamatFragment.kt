package com.psi.tempesanan.fragments

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_alamat.*



class AlamatFragment : Fragment() {


        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val v: View =
                inflater.inflate(com.psi.tempesanan.R.layout.fragment_alamat, container, false)


            val listnrr: View.OnClickListener = object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val Alamat = Intent(android.content.Intent.ACTION_VIEW)
                    Alamat.data = Uri.parse("https://goo.gl/maps/J42mZsKTWDWuYSKQ8")
                    startActivity(Alamat)
                }
            }
            val btnAlamat = v.findViewById<View>(com.psi.tempesanan.R.id.btn_alamat) as Button
            btnAlamat.setOnClickListener(listnrr)
            return v
        }
}
