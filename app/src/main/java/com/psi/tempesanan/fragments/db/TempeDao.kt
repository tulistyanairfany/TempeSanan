package com.psi.tempesanan.fragments.db

import androidx.room.*
import com.psi.tempesanan.fragments.model.Tempe


@Dao
interface TempeDao {

    @Insert
    fun insert(tempe: Tempe)

    @Update
    fun update(tempe: Tempe)

    @Delete
    fun delete(tempe: Tempe)

    @Query("SELECT * FROM tabelproduk")
    fun getAll() : List<Tempe>

    @Query("Select * FROM tabelproduk WHERE id = :id")
    fun getById(id: Int) : List<Tempe>
}