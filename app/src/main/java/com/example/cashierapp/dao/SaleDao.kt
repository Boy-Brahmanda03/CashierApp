package com.example.cashierapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cashierapp.entity.BuyItems
import com.example.cashierapp.entity.Sale
import com.example.cashierapp.entity.SaleItemCrossRef
import com.example.cashierapp.entity.relation.ItemWithSales
import com.example.cashierapp.entity.relation.SaleWithItems

@Dao
interface SaleDao {
    //sale
    @Insert
    fun insertSale(sale: Sale)

    @Query("select * from sale order by saleID DESC")
    fun getAllSales(): List<Sale>

    @Update
    fun updateSale(sale: Sale): Int

    @Delete
    fun deleteSale(sale: Sale)

    @Query("SELECT * FROM sale where saleID = :id group by saleID")
    fun getSaleWithItems(id: Int): SaleWithItems


    @Query("SELECT * FROM item")
    fun getItemWithSales(): List<ItemWithSales>



    //cross ref
    @Insert
    fun insertCrossRef(crossRef: SaleItemCrossRef)

    @Update
    fun updateCrossRef(crossRef: SaleItemCrossRef)


    @Query("Select sum(subTotal) from SaleItemCrossRef where saleID = :sId")
    fun sumSale(sId: Int): Long

    @Query("Select sum(total) from Sale")
    fun getSum(): Long

    @Query("select * from saleitemcrossref where saleID = :sId")
    fun getSalesDetail(sId: Int): List<SaleItemCrossRef>




    @Insert
    fun insertBuyItem(buyItems: BuyItems)

    @Query("SELECT * from buyitems")
    fun getItem(): List<BuyItems>

}