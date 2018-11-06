package ru.finfly.mobilecashregistrator

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface CashMemoDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertCashMemo(cashMemo:CashMemo)

    @Query("SELECT * FROM CashMemo ORDER BY cum DESC")
    fun getAllMemos(): LiveData<List<CashMemo>>

}