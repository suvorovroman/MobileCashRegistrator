package ru.finfly.mobilecashregistrator

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
data class CashMemo
(
        @PrimaryKey
        val quid:   String = UUID.randomUUID().toString(),
        val value:  Double,
        val state:  Int = 0
)
