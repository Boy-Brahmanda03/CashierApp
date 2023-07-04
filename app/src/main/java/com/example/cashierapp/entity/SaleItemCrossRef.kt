package com.example.cashierapp.entity

import androidx.room.Entity


@Entity(primaryKeys = ["userID", "itemID"])
data class SaleItemCrossRef(
    val userID: Int,
    val itemID: Int,
    val quantity: Int,
    val subTotal: Long
)
