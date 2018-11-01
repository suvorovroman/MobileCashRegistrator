package ru.finfly.mobilecashregistrator

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy

@Dao
interface CashMemoDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertCashMemo(cashMemo:CashMemo)

}