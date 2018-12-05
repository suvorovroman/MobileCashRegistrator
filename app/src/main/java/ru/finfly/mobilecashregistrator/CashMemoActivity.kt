package ru.finfly.mobilecashregistrator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.cash_memo.*
import java.util.*

abstract class CashMemoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cash_memo)

        ArrayAdapter.createFromResource(
                this,
                R.array.currency_sign,
                R.layout.currency_spinner_layout
        ).also {
            it.setDropDownViewResource(R.layout.currency_spinner_layout)
            monetae.adapter = it
        }

        fab.setOnClickListener {
            onFab()
            finish()
        }
    }

    abstract fun onFab()

}