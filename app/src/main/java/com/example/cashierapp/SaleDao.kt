package com.example.cashierapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cashierapp.entity.Sale
import com.example.cashierapp.entity.relation.SaleWithItems

@Dao
interface SaleDao {
    @Insert
    fun insertSale(sale: Sale)

    @Query("select * from sale")
    fun getAllSales(): List<Sale>

    @Query("SELECT * FROM sale")
    fun getSaleWithItems(): List<SaleWithItems>

    @Query("SELECT SUM(total) FROM Sale")
    fun getSum(): Int
}