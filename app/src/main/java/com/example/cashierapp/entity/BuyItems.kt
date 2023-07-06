package com.example.cashierapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BuyItems(
    @PrimaryKey
    val itemName: String,
    val qty: Int,
    val price: Long
)
