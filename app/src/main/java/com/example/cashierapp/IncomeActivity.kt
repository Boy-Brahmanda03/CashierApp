package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cashierapp.adapter.ListAdapter
import com.example.cashierapp.entity.AppDatabase

class IncomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income)
        initComponents()
        val db = AppDatabase.getDatabase(this).saleDao()
        val totalIncome = db.getSum()

        val totalTV = findViewById<TextView>(R.id.tvTotal)
        totalTV.text = "Rp. $totalIncome"

        val recyclerView = findViewById<RecyclerView>(R.id.rvListIncome)
        val Sales= db.getAllSales()
        val adapter = ListAdapter(Sales)

        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            val intent = Intent(this, ReportActivity::class.java)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
    private fun initComponents(){
        recyclerView = findViewById(R.id.rvListIncome)
    }

}