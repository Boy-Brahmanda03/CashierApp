package com.example.cashierapp.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.cashierapp.entity.Sale
import com.example.cashierapp.entity.User

data class UserWithSales(
    @Embedded val user:User,
    @Relation(
        parentColumn = "userID",
        entityColumn = "userCreatorID"
    )
    val sales: List<Sale>
)
