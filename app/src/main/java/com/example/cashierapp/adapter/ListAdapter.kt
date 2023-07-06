package com.example.cashierapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cashierapp.databinding.ListItemDataBinding
import com.example.cashierapp.entity.Sale

class ListAdapter(
    val sell: List<Sale>
): RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: ListItemDataBinding): RecyclerView.ViewHolder(binding.root)

    var onItemClick : ((Sale) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemDataBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return sell.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = sell[position]
        holder.binding.apply {
            tvIdSell.text = currentItem.saleID.toString()
            tvTotal.text = currentItem.total.toString()
            tvDate.text = currentItem.date.toString()
        }
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }

    }

}