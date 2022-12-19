package com.psi.tempesanan.fragments.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tabeltransaksi")

@Parcelize
data class Transaksi (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_transaksi") var id_transaksi: Int = 0,
    @ColumnInfo(name = "tgl_transaksi") var tgl_transaksi: String = "",
    @ColumnInfo(name = "id") var id: Int = 0
        ) : Parcelable {

        }