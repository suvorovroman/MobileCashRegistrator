package ru.finfly.mobilecashregistrator

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.ViewGroup
import android.widget.TextView
import ru.finfly.mobilecashregistrator.R.id.guid
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

        fun fill(cashMemo: CashMemo){
            guidText.text = cashMemo.quid
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

    fun setList(new_list: List<CashMemo>){
        list = new_list
        notifyDataSetChanged()
    }

}