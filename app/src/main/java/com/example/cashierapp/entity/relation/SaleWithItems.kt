package com.example.cashierapp.entity.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.cashierapp.entity.Item
import com.example.cashierapp.entity.Sale
import com.example.cashierapp.entity.SaleItemCrossRef

data class SaleWithItems(
    @Embedded val sale: Sale,
    @Relation(
        parentColumn = "saleID",
        entityColumn = "itemID",
        associateBy = Junction(SaleItemCrossRef::class)
    )
    val items: List<Item>
)
