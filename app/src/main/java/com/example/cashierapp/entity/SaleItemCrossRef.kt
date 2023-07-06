package com.example.cashierapp.entity

import androidx.room.Entity


@Entity(primaryKeys = ["saleID", "itemID"])
data class SaleItemCrossRef(
    val saleID: Int,
    val itemID: Int,
    var quantity: Int = 1,
    var subTotal: Long = 0
)
