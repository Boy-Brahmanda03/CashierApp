package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cdLaporan = findViewById<CardView>(R.id.cdLaporan)
        cdLaporan.setOnClickListener {
            val intent = Intent(this, LaporanActivity2::class.java)
            startActivity(intent)
        }

        val cdProfile = findViewById<CardView>(R.id.cdProfile)
        cdProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        val btn = findViewById<CardView>(R.id.cdBarang)
        btn.setOnClickListener {
            val intent = Intent(this, LaporanActivity2::class.java)
            startActivity(intent)
        }
    }
}