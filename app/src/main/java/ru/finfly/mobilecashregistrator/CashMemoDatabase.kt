package ru.finfly.mobilecashregistrator

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import kotlin.IllegalStateException

@Database(entities = [CashMemo::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CashMemoDatabase: RoomDatabase() {

    abstract fun cashMemoDao(): CashMemoDao

    companion object {

        private var instance: CashMemoDatabase? = null

        fun getInstance(context: Context):CashMemoDatabase{
            if(instance == null) {
                synchronized(CashMemoDatabase::class) {
                    if(instance == null) {
                        instance = Room.inMemoryDatabaseBuilder(
                                context.applicationContext,
                                CashMemoDatabase::
                                class.java).build()
                    }
                }
            }
            return instance ?: throw IllegalStateException("Failed to obtain database access")
        }

    }

}