package com.example.cashierapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cashierapp.entity.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM User")
    fun getAllUser(): List<User>
}