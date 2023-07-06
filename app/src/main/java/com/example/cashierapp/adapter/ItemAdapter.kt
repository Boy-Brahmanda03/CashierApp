package com.example.cashierapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cashierapp.databinding.ItemsListBinding
import com.example.cashierapp.entity.Item



class ItemAdapter(
    val items: List<Item>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: ItemsListBinding): RecyclerView.ViewHolder(binding.root)

    var onItemClick : ((Item) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemsListBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.binding.apply {
            itemnameTv.text = currentItem.itemName
            itemstockTv.text = currentItem.itemStock.toString()
            itempriceTv.text = currentItem.itemPrice.toString()
        }
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }

    }

}