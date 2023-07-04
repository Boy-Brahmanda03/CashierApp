package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cashierapp.entity.AppDatabase
import com.example.cashierapp.entity.Sale

class SaleActivity : AppCompatActivity() {
    private lateinit var btnBack: ImageView
    private lateinit var btnAdd: Button
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sale)
        initComponents()
        val db = AppDatabase.getDatabase(this)
        val itemDao = db.itemDao()
        val saleDao = db.saleDao()
        val items= itemDao.getAllItem()
//        val sale = Sale(0, )
        val adapter = ItemAdapter(items)
        adapter.onItemClick = {
            val intent = Intent(this, SaleAddActivity::class.java)
            intent.putExtra("id", it.itemID)
            intent.putExtra("nama", it.itemName)
            intent.putExtra("stok", it.itemStock.toString())
            intent.putExtra("harga", it.itemPrice.toString())
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        btnBack.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initComponents(){
        btnAdd = findViewById(R.id.add_btn)
        recyclerView = findViewById(R.id.items_rv)
        btnBack = findViewById(R.id.back_btn)
    }
}