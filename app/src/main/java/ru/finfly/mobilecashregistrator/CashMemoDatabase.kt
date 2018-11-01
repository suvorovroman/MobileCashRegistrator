package ru.finfly.mobilecashregistrator

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [CashMemo::class], version = 1, exportSchema = false)
abstract class CashMemoDatabase:RoomDatabase() {

    abstract fun cashMemoDao(): CashMemoDao

    companion object {

        private var instance: CashMemoDatabase? = null

        fun getInstance(context: Context):CashMemoDatabase?{
            if(instance == null){
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            CashMemoDatabase::class.java,
                            "cashmemo.db").build()
            }
            return instance
        }

    }

}