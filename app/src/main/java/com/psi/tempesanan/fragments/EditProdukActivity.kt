package com.psi.tempesanan.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.room.Constant
import com.psi.tempesanan.fragments.room.Tempe
import com.psi.tempesanan.fragments.room.TempeDB
import kotlinx.android.synthetic.main.activity_edit_produk.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.psi.tempesanan.fragments.room.TempeDao

class EditProdukActivity : AppCompatActivity() {


        private val db by lazy { TempeDB(this) }
        private var tempeId = 0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_edit_produk)
            setupView()
            setupLstener()
        }

        private fun setupView(){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            when (intentType()) {
                Constant.TYPE_CREATE -> {
                    supportActionBar!!.title = "BUAT BARU"
                    button_save_produk.visibility = View.VISIBLE
                    button_update_produk.visibility = View.GONE
                }
                Constant.TYPE_READ -> {
                    supportActionBar!!.title = "BACA"
                    button_save_produk.visibility = View.GONE
                    button_update_produk.visibility = View.GONE
                    getTempe()
                }
                Constant.TYPE_UPDATE -> {
                    supportActionBar!!.title = "EDIT"
                    button_save_produk.visibility = View.GONE
                    button_update_produk.visibility = View.VISIBLE
                    getTempe()
                }
            }
        }

        private fun setupLstener(){
            button_save_produk.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    db.TempeDao().addTempe(
                        Tempe(
                            0,
                            edit_namaproduk.text.toString(),
                            edit_hargaproduk.text.toString()
                        )
                    )
                    finish()
                }
            }
            button_update_produk.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    db.TempeDao().updateTempe(
                        Tempe(
                            tempeId,
                            edit_namaproduk.text.toString(),
                            edit_hargaproduk.text.toString()
                        )
                    )
                    finish()
                }
            }
        }

        private fun getTempe(){
            tempeId = intent.getIntExtra("tempe_id", 0)
            CoroutineScope(Dispatchers.IO).launch {
                val tempes = db.TempeDao().getTempe(tempeId).get(0)
                edit_namaproduk.setText( tempes.namabarang )
                edit_hargaproduk.setText( tempes.harga )
            }
        }

        override fun onSupportNavigateUp(): Boolean {
            finish()
            return super.onSupportNavigateUp()
        }

        private fun intentType(): Int {
            return intent.getIntExtra("intent_type", 0)
        }
    }

