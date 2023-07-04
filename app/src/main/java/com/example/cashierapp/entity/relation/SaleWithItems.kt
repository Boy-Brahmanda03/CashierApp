package com.example.cashierapp.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.cashierapp.entity.Item
import com.example.cashierapp.entity.Sale

data class SaleWithItems(
    @Embedded val saleID: Sale,
    @Relation(
        parentColumn = "saleID",
        entityColumn = "itemID"
    )
    val items: List<Item>
)
