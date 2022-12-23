package com.psi.tempesanan.fragments.db

import androidx.room.*
import com.psi.tempesanan.fragments.model.Transaksi

@Dao
interface TransaksiDao {
    @Insert
    fun insert(transaksi: Transaksi)

    @Update
    fun update(transaksi: Transaksi)

    @Delete
    fun delete(transaksi: Transaksi)

    @Query("SELECT * FROM tabeltransaksi")
    fun getAll() : List<Transaksi>

    @Query("Select * FROM tabeltransaksi WHERE id_transaksi = :id_transaksi")
    fun getById(id_transaksi: Int) : List<Transaksi>
}