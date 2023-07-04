package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.cashierapp.entity.AppDatabase

class IncomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income)
        val db = AppDatabase.getDatabase(this)
        val dao = db.saleDao()
        val totalIncome = dao.getSum()

        val totalTV = findViewById<TextView>(R.id.tvTotal)
        totalTV.text = "Rp. $totalIncome"

        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            val intent = Intent(this, ReportActivity::class.java)
            startActivity(intent)
        }
    }
}