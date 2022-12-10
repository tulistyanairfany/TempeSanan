package com.psi.tempesanan.fragments.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Tempe::class],
    version = 1
)

abstract class TempeDB {
    abstract fun TempeDao() : TempeDao

    companion object {

        @Volatile private var instance :  TempeDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TempeDB::class.java,
            "TempeSanan.db"
        ).build()

    }
}
