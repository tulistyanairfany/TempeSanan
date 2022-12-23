package com.psi.tempesanan.fragments.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tabeltransaksi")

@Parcelize
data class Transaksi (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_transaksi") var id_transaksi: Int = 0,
    @ColumnInfo(name = "tanggaltrans") var tanggaltrans: String = "",
    @ColumnInfo(name = "namapelanggantrans") var namapelanggantrans: String = "",
    @ColumnInfo(name = "namabarangtrans") var namabarangtrans: String = "",
    @ColumnInfo(name = "hargabarangtrans") var hargabarangtrans: String = "",
    @ColumnInfo(name = "id") var id: Int = 0
        ) : Parcelable {

        }