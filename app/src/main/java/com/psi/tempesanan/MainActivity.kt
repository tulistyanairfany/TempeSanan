package com.psi.tempesanan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.psi.tempesanan.fragments.BerandaFragment
import com.psi.tempesanan.fragments.AlamatFragment
import com.psi.tempesanan.fragments.TentangFragment

class MainActivity : AppCompatActivity() {

    private val berandaFragment = BerandaFragment()
    private val tentangFragment = TentangFragment()
    private val alamatFragment = AlamatFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(berandaFragment)

        findViewById<BottomNavigationView>(R.id.bottom_navigation)
            .setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_beranda -> replaceFragment(berandaFragment)
                R.id.ic_tentang -> replaceFragment(tentangFragment)
                R.id.ic_alamat -> replaceFragment(alamatFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}