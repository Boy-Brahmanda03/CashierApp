package com.example.cashierapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val userID: Int,
    val userName: String,
    val email: String,
    val telepon: String,
    val password: String
)
