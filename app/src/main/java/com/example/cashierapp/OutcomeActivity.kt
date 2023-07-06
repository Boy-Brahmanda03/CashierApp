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

class OutcomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outcome)

        val recyclerView = findViewById<RecyclerView>(R.id.rvListOutcome)
        val db = AppDatabase.getDatabase(this).saleDao()
        val totalIncome = db.getSum()

        val totalTV = findViewById<TextView>(R.id.tvTotal)
        totalTV.text = "Rp. $totalIncome"

        val Sales= db.getAllSales()
        val adapter = ListAdapter(Sales)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            val intent = Intent(this, ReportActivity::class.java)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun initComponents(){
        recyclerView = findViewById(R.id.rvListOutcome)
    }

}