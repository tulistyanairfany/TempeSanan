package com.psi.tempesanan.fragments.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.psi.tempesanan.fragments.model.Pelanggan
import com.psi.tempesanan.fragments.model.Transaksi

data class PelangganWithTransaksis (
    @Embedded val pelanggan : Pelanggan,
    @Relation(
        parentColumn = "namaPelanggan",
        entityColumn = "namaPelanggan"
    )
    val transaksis: List<Transaksi>
)