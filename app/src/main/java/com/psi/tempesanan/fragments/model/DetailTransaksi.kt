package com.psi.tempesanan.fragments.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tabelDetailTransaksi")

@Parcelize
data class DetailTransaksi (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_detailTransaksi") var id_detailTransaksi: Int = 0,
    @ColumnInfo(name = "kuantitas") var kuantitas: Int = 0,
    @ColumnInfo(name = "total") var total: String = "",
    @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "id_transaksi") var id_transaksi: Int = 0
) : Parcelable {

}