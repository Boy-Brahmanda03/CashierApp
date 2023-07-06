package com.example.cashierapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sale(
    @PrimaryKey(autoGenerate = true)
    val saleID: Int,
    val userCreatorID: Int,
    val date: String,
    var total: Long = 0
)
