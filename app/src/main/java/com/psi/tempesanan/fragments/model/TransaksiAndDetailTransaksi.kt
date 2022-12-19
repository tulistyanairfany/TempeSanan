package com.psi.tempesanan.fragments.model

import androidx.room.Embedded
import androidx.room.Relation

data class TransaksiAndDetailTransaksi(
    @Embedded val transaksi: Transaksi,
    @Relation(
        parentColumn = "id_transaksi",
        entityColumn = "id_transaksi"
    )
    val detailTransaksi: DetailTransaksi
)