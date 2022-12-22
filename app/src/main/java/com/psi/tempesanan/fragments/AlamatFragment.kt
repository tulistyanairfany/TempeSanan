package com.psi.tempesanan.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.psi.tempesanan.R
import kotlinx.android.synthetic.main.fragment_alamat.*


class AlamatFragment : Fragment() {


        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_alamat, container, false)

            btnalamat.setOnClickListener {
                val openURL = Intent(android.content.Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://goo.gl/maps/J42mZsKTWDWuYSKQ8")
                startActivity(openURL)
            }

        }

}



