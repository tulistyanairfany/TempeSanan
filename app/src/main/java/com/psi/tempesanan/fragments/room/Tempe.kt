package com.psi.tempesanan.fragments.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tempe(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val namabarang: String,
    val harga: String
)