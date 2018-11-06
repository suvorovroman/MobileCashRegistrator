package ru.finfly.mobilecashregistrator

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.content.Context

class CashMemoViewModel(application: Application):AndroidViewModel(application) {

    private val repository = CashMemoRepository(application)

    val memo_list = repository.getAllMemos()

}