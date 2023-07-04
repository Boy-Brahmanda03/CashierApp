package com.example.cashierapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class ReportActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(/* layoutResID = */ R.layout.activity_report)


        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        val cdOutcome = findViewById<CardView>(R.id.cd_outcome)
        cdOutcome.setOnClickListener {
            val intent = Intent(this, OutcomeActivity::class.java)
            startActivity(intent)
        }

        val cdIncome = findViewById<CardView>(R.id.cd_income)
        cdIncome.setOnClickListener {
            val intent = Intent(this, IncomeActivity::class.java)
            startActivity(intent)
        }
    }


}