//package com.psi.tempesanan.fragments.db
//
//import androidx.room.*
//import com.psi.tempesanan.fragments.model.Tempe
//import com.psi.tempesanan.fragments.model.Transaksi
//
//@Dao
//interface TransaksiDao {
//    @Insert
//    fun insert(transaksi: Transaksi)
//
//    @Update
//    fun update(transaksi: Transaksi)
//
//    @Delete
//    fun delete(tempe: Tempe)
//
//    @Query("SELECT * FROM tabeltransaksi")
//    fun getAll() : List<Transaksi>
//
//    @Query("Select * FROM tabeltransaksi WHERE id = :id")
//    fun getById(id: Int) : List<Transaksi>
//}