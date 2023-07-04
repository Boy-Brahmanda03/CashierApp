package com.example.cashierapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val itemID: Int,
    val itemName: String,
    val itemStock: Int,
    val itemPrice: Long
)
