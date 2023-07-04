package com.example.cashierapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cashierapp.entity.Item
import com.example.cashierapp.entity.relation.ItemWithSales

@Dao
interface ItemDao {
    @Insert
    fun insertItem(item: Item)

    @Update
    fun updateItem(item: Item)

    @Delete
    fun deleteItem(item: Item)

    @Query("SELECT * FROM Item")
    fun getAllItem(): List<Item>

    @Query("SELECT * FROM Item where itemID = :id")
    fun getItem(id: Int): Item

    @Query("SELECT * FROM item")
    fun getItemWithSales(): List<ItemWithSales>
}