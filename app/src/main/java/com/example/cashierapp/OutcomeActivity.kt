package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cashierapp.entity.AppDatabase
import com.example.cashierapp.entity.Sale

class OutcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outcome)

        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            val intent = Intent(this, ReportActivity::class.java)
            startActivity(intent)
        }



        val sale = Sale(0,1,"2020", 1000000)
        val recyclerView = findViewById<RecyclerView>(R.id.rvListData)

        val db = AppDatabase.getDatabase(this).saleDao()
        db.insertSale(sale)
        val items= db.getAllSales()
        val adapter = ListAdapter(items)
//        adapter.onItemClick = {
//            val intent = Intent(this, ItemEditActivity::class.java)
//            intent.putExtra("id", it.itemID)
//            intent.putExtra("nama", it.itemName)
//            intent.putExtra("stok", it.itemStock.toString())
//            intent.putExtra("harga", it.itemPrice.toString())
//            startActivity(intent)
//        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


    }


}