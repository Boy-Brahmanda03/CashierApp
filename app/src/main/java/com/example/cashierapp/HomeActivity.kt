package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.cardview.widget.CardView
import com.example.cashierapp.entity.AppDatabase

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val emailLogin = intent.getStringExtra("email").toString()
        val db = AppDatabase.getDatabase(this).userDao()
        val userLogin = db.getUser(emailLogin)
        val uId = userLogin.userID
        val uname = userLogin.userName

        val cdLaporan = findViewById<CardView>(R.id.cdLaporan)
        cdLaporan.setOnClickListener {
            val intent = Intent(this, OutcomeActivity::class.java)
            intent.putExtra("idUser", uId.toString())
            intent.putExtra("uname", uname)
            startActivity(intent)
        }

        val cdProfile = findViewById<CardView>(R.id.cdProfile)
        cdProfile.setOnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            intent.putExtra("email", emailLogin)
            startActivity(intent)
        }

        val btn = findViewById<CardView>(R.id.cdBarang)
        btn.setOnClickListener {
            val intent = Intent(this, ItemActivity::class.java)
            startActivity(intent)
        }

        val btnTransaksi = findViewById<CardView>(R.id.cdTransaksi)
        btnTransaksi.setOnClickListener {
            val intent = Intent(this, SaleActivity::class.java)
            intent.putExtra("idUser", uId)
            intent.putExtra("uname", uname)
            startActivity(intent)
        }

    }
}