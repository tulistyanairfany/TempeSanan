package com.psi.tempesanan.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.psi.tempesanan.R


// TODO: Rename parameter arguments, choose names that match

class BerandaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_beranda, container, false)

        val listnr: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(activity, TransaksiActivity::class.java)
                startActivity(intent)
            }
        }
        val listnr2: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent2 = Intent(activity, ProdukActivity::class.java)
                startActivity(intent2)
            }
        }
        val listnr3: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent3 = Intent(activity, PelangganActivity::class.java)
                startActivity(intent3)
            }
        }
        val btn = v.findViewById<View>(R.id.btntransaksi) as Button
        btn.setOnClickListener(listnr)
        val btn2 = v.findViewById<View>(R.id.btnproduk) as Button
        btn2.setOnClickListener(listnr2)
        val btn3 = v.findViewById<View>(R.id.btnpelanggan) as Button
        btn3.setOnClickListener(listnr3)
        return v
    }

}




