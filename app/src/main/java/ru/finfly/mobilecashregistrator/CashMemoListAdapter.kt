package ru.finfly.mobilecashregistrator

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.ViewGroup
import android.widget.TextView
import ru.finfly.mobilecashregistrator.R.id.*
import java.util.*

class CashMemoListAdapter(context: Context):RecyclerView.Adapter<CashMemoListAdapter.ItemViewHolder>(){

    private val inflater = LayoutInflater.from(context)

    private var list:List<CashMemo> = emptyList()

    inner class ItemViewHolder(parent: ViewGroup):RecyclerView.ViewHolder(
            inflater.inflate(
                    R.layout.cash_memo_view_holder,
                    parent,
                    false
            )
    ){
        val guidText = itemView.findViewById<TextView>(R.id.guid)
        val amountText = itemView.findViewById<TextView>(R.id.amount)
        val whenText = itemView.findViewById<TextView>(R.id.`when`)
        val whoText = itemView.findViewById<TextView>(R.id.who)
        val whatText = itemView.findViewById<TextView>(R.id.what)
        val lidText = itemView.findViewById<TextView>(R.id.lid)
        val monetae = itemView.findViewById<TextView>(R.id.monetae)

        fun fill(cashMemo: CashMemo){
            lidText.text = cashMemo.lid.toString()
            guidText.text = cashMemo.quid
            amountText.text = cashMemo.quantum.toString()
            whenText.text = cashMemo.cum.toString()
            whoText.text = cashMemo.qui
            whatText.text = cashMemo.quid
            monetae.text = cashMemo.monetae.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.fill(list[position])
    }

    override fun getItemCount(): Int{
        return list.size
    }

    fun setList(new_list: List<CashMemo>?){
        if(new_list == null)
            list = emptyList<CashMemo>()
        else
            list = new_list
        notifyDataSetChanged()
    }

}