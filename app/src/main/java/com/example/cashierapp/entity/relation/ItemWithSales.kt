package com.example.cashierapp.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.cashierapp.entity.Item
import com.example.cashierapp.entity.Sale

data class ItemWithSales(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "itemID",
        entityColumn = "saleID"
    )
    val sales: List<Sale>
)
