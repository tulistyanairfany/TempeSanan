package com.psi.tempesanan.fragments.db

import androidx.room.*
import com.psi.tempesanan.fragments.model.*

@Dao
interface DetailTransaksiDao {
    @Insert
    fun insert(detailTransaksi: DetailTransaksi)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaksi(trasaksi: Transaksi)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTempe(tempe: Tempe)

    @Update
    fun update(detailTransaksi: DetailTransaksi)

    @Delete
    fun delete(detailTransaksi: DetailTransaksi)

    @Query("SELECT * FROM tabelDetailTransaksi")
    fun getAll() : List<DetailTransaksi>

    @Query("SELECT * FROM tabelDetailTransaksi WHERE id_detailTransaksi = :id_detailTransaksi")
    fun getById(id_detailTransaksi: Int) : List<DetailTransaksi>

    @Transaction
    @Query("SELECT * FROM tabeltransaksi WHERE id_transaksi = :id_transaksi")
    suspend fun getTransaksiAndDetailTransaksi(id_transaksi: Int): List<TransaksiAndDetailTransaksi>

    @Transaction
    @Query("SELECT * FROM tabelDetailTransaksi WHERE id = :id")
    suspend fun getDetailTransaksiWithProduk (id: Int): List<DetailTransaksiWithProduk>
}