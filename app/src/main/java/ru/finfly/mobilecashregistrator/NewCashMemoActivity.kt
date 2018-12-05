package ru.finfly.mobilecashregistrator

import android.os.AsyncTask
import kotlinx.android.synthetic.main.cash_memo.*

class NewCashMemoActivity:CashMemoActivity() {

    private inner class InsertCashMemoTask:AsyncTask<CashMemo, Void, Unit>(){

        override fun doInBackground(vararg params: CashMemo?): Unit {
            for(cash_memo in params)
                if(cash_memo != null)
                    CashMemoDatabase.getInstance(this@NewCashMemoActivity).cashMemoDao().insertCashMemo(cash_memo)
        }

    }

    override fun onFab()
    {
        if(quantum.text.isNotEmpty())
        {
            InsertCashMemoTask().execute(CashMemo(
                    quantum = quantum.text.toString().toDouble(),
                    qui = qui.text.toString(),
                    quid = quid.text.toString()
                )
            )
        }
    }

}