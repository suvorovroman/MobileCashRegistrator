package ru.finfly.mobilecashregistrator

import android.arch.lifecycle.LiveData
import android.content.Context

class CashMemoRepository(context: Context) {

    private val dao = CashMemoDatabase.getInstance(context)!!.cashMemoDao()

    fun getAllMemos(): LiveData<List<CashMemo>>{
        return dao.getAllMemos()
    }

}