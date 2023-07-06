package com.example.cashierapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cashierapp.databinding.ItemSalesBinding
import com.example.cashierapp.entity.Item

class SaleItemAdapter(
    val items: List<Item>
): RecyclerView.Adapter<SaleItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: ItemSalesBinding): RecyclerView.ViewHolder(binding.root)

    var onItemClick : ((Item) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSalesBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        var qty = 0
        holder.binding.apply {
            itemnameTv.text = currentItem.itemName
            stokTv.text = currentItem.itemStock.toString()
            addQty.setOnClickListener {
                qty++
                qtyTv.text = qty.toString()
            }
            minQty.setOnClickListener {
                qty--
                qtyTv.text = qty.toString()
            }
        }
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }
    }
}

