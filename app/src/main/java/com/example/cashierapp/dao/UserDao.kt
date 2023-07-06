package com.example.cashierapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cashierapp.entity.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("Update User set password = :pass where email = :email")
    fun updateUser(email: String, pass: String)

    @Query("SELECT * FROM User")
    fun getAllUser(): List<User>

    @Query("SELECT * FROM User WHERE email = :email")
    fun getUser(email: String): User

    @Query("SELECT * FROM User WHERE email = :email")
    fun userLogin(email: String): Boolean

    @Update
    fun updateProfile(user: User)
}