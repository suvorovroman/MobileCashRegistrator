package ru.finfly.mobilecashregistrator

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.content.Context

class CashMemoViewModel(application: Application):AndroidViewModel(application) {

    private val dao = CashMemoDatabase.getInstance(application).cashMemoDao()

    val list = dao.getAllMemos()

}