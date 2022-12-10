package com.psi.tempesanan.fragments.room

import androidx.room.*

@Dao
interface TempeDao {
    @Insert
    suspend fun addTempe(tempe: Tempe)

    @Query("SELECT * FROM tempe ORDER BY id DESC")
    suspend fun getTempes() : List<Tempe>

    @Query("SELECT * FROM tempe WHERE id=:tempe_id")
    suspend fun getTempe(tempe_id: Int) : List<Tempe>

    @Update
    suspend fun updateTempe(tempe: Tempe)

    @Delete
    suspend fun deleteTempe(tempe: Tempe)
}