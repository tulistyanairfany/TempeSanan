package com.psi.tempesanan.fragments.model

import androidx.room.Embedded
import androidx.room.Relation

data class DetailTransaksiWithProduk (
    @Embedded val detailTransaksi: DetailTransaksi,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
        )
    val tempes : List<Tempe>
)