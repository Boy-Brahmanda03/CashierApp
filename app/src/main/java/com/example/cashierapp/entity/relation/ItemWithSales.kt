package com.example.cashierapp.entity.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.cashierapp.entity.Item
import com.example.cashierapp.entity.Sale
import com.example.cashierapp.entity.SaleItemCrossRef

data class ItemWithSales(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "itemID",
        entityColumn = "saleID",
        associateBy = Junction(SaleItemCrossRef::class)
    )
    val sales: List<Sale>
)
