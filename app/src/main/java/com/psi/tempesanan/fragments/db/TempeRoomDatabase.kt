package com.psi.tempesanan.fragments.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.psi.tempesanan.fragments.model.Pelanggan
import com.psi.tempesanan.fragments.model.Tempe


@Database (entities = [Tempe::class, Pelanggan::class], version = 4, exportSchema = false)

abstract class TempeRoomDatabase : RoomDatabase (){

    companion object {
        @Volatile
        private var INSTANCE: TempeRoomDatabase?= null

        fun getDatabase(context: Context): TempeRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                //Buat Database
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TempeRoomDatabase::class.java,
                    "TempeSanan_db"
                )

                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
    abstract fun getTempeDao() : TempeDao
    abstract fun getPelangganDao() : PelangganDao
}