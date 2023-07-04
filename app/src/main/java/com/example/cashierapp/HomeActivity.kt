package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        val cdLaporan = findViewById<CardView>(R.id.cdLaporan)
        cdLaporan.setOnClickListener {
            val intent = Intent(this, OutcomeActivity::class.java)
            startActivity(intent)
        }

//        val cdProfile = findViewById<CardView>(R.id.cdProfile)
//        cdProfile.setOnClickListener {
//            val intent = Intent(this, ProfileActivity::class.java)
//            startActivity(intent)
//        }

        val btn = findViewById<CardView>(R.id.cdBarang)
        btn.setOnClickListener {
            val intent = Intent(this, ItemActivity::class.java)
            startActivity(intent)
        }

        val btnTransaksi = findViewById<CardView>(R.id.cdTransaksi)
        btnTransaksi.setOnClickListener {
            val intent = Intent(this, SaleActivity::class.java)
            startActivity(intent)
        }

        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}