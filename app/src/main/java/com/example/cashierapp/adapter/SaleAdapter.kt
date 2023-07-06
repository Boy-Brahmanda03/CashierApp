package com.example.cashierapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cashierapp.databinding.SalesListBinding
import com.example.cashierapp.entity.AppDatabase
import com.example.cashierapp.entity.SaleItemCrossRef
import com.example.cashierapp.entity.relation.SaleWithItems

class SaleAdapter(
    private val saleWithItems: SaleWithItems,
    private val crossRef: List<SaleItemCrossRef>
): RecyclerView.Adapter<SaleAdapter.SaleViewHolder>() {
    inner class SaleViewHolder(val binding: SalesListBinding): RecyclerView.ViewHolder(binding.root)

    var onItemClick : ((SaleWithItems) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SalesListBinding.inflate(inflater, parent, false)
        return SaleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return saleWithItems.items.size
    }

    override fun onBindViewHolder(holder: SaleViewHolder, position: Int) {
        val saleItems = saleWithItems.items
        val crossrefs = crossRef[position]
        holder.binding.apply {
            itemnameTv.text = saleItems[position].itemName
            priceTv.text = saleItems[position].itemPrice.toString()
            subtotalTv.text = crossrefs.subTotal.toString()
            qtyTv.text = crossrefs.quantity.toString()
        }
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(saleWithItems)
        }
    }

}