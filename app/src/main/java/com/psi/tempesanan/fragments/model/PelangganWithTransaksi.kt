package com.psi.tempesanan.fragments.model

import androidx.room.Embedded
import androidx.room.Relation

data class PelangganWithTransaksi (
    @Embedded val pelanggan: Pelanggan,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val transaksis : List<Transaksi>
    )