package ru.finfly.mobilecashregistrator

import android.os.AsyncTask
import kotlinx.android.synthetic.main.cash_memo.*

class NewCashMemoActivity:CashMemoActivity() {

    private inner class InsertCashMemoTask:AsyncTask<CashMemo, Void, Unit>(){

        override fun doInBackground(vararg params: CashMemo) {
            for(memo in params)
                CashMemoDatabase.getInstance(
                        this@NewCashMemoActivity
                ).cashMemoDao().insertCashMemo(memo)
        }

    }

    override fun onFab()
    {
        if(quantum.text.isNotEmpty())
            InsertCashMemoTask().execute(CashMemo(
                    quantum = quantum.text.toString().toDouble()*if(direction.isChecked) 1 else -1,
                    qui = qui.text.toString(),
                    quid = quid.text.toString(),
                    monetae = monetae.selectedItemPosition
                )
            )
    }

}