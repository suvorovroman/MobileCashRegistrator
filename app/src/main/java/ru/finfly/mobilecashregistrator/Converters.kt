package ru.finfly.mobilecashregistrator

import android.arch.persistence.room.TypeConverter
import java.util.*

class Converters {
    companion object {

        @TypeConverter
        @JvmStatic
        fun fromDate(value: Date):Long
        {
            return value.time
        }

        @TypeConverter
        @JvmStatic
        fun toDate(value: Long):Date{
            return Date(value)
        }
    }
}