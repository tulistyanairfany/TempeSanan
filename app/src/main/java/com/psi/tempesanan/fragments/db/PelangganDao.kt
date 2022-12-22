package com.psi.tempesanan.fragments.db

import androidx.room.*
import com.psi.tempesanan.fragments.model.Pelanggan
import com.psi.tempesanan.fragments.model.Tempe

@Dao
interface PelangganDao {
    @Insert
    fun insert(pelanggan: Pelanggan)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertTransaksi(trasaksi: Transaksi)

    @Update
    fun update(pelanggan: Pelanggan)

    @Delete
    fun delete(pelanggan: Pelanggan)

    @Query("SELECT * FROM tabelpelanggan")
    fun getAll() : List<Pelanggan>

    @Query("Select * FROM tabelpelanggan WHERE id = :id")
    fun getById(id: Int) : List<Pelanggan>

//    @Transaction
//    @Query("SELECT * FROM tabelpelanggan WHERE id = :id")
//    suspend fun getPelangganWithTransaksis(id: Int): List<PelangganWithTransaksis>

}