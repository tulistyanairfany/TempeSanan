package com.psi.tempesanan.fragments.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//Nama Entity spesifik tabel
@Entity (tableName = "tabelproduk")

@Parcelize
data class Tempe (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int = 0,
            @ColumnInfo(name = "namabarang") var namabarang: String = "",
                    @ColumnInfo(name = "hargabarang") var hargabarang: String = ""
    ) : Parcelable {
}
