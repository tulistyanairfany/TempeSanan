package com.psi.tempesanan.fragments.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//Nama Entity spesifik tabel
@Entity(tableName = "tabelpelanggan")

@Parcelize
data class Pelanggan (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "namapelanggan") var namapelanggan: String = "",
    @ColumnInfo(name = "nomortelp") var nomortelp: String = ""
    ) : Parcelable {
    }