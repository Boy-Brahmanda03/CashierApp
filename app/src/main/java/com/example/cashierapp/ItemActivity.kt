package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.cashierapp.entity.AppDatabase
import com.example.cashierapp.entity.Item

class ItemActivity : AppCompatActivity() {
    private lateinit var btnAdd: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnBack : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        initComponents()
        val db = AppDatabase.getDatabase(this).itemDao()
        val items= db.getAllItem()
        val adapter = ItemAdapter(items)
        adapter.onItemClick = {
            val intent = Intent(this, ItemEditActivity::class.java)
            intent.putExtra("id", it.itemID)
            intent.putExtra("nama", it.itemName)
            intent.putExtra("stok", it.itemStock.toString())
            intent.putExtra("harga", it.itemPrice.toString())
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val intent = Intent(this, ItemAddActivity::class.java)
            startActivity(intent)
        }

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