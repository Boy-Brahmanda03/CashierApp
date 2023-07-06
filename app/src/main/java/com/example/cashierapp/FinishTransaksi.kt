package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinishTransaksi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_transaksi)
        val total = intent.getLongExtra("total", 0)
        val change = intent.getLongExtra("change", 0)


        val changeTv = findViewById<TextView>(R.id.textView5)
        val totalTV = findViewById<TextView>(R.id.textView3)
        totalTV.text = "Rp. $total"
        changeTv.text = "Rp. $change"

        val done = findViewById<Button>(R.id.btn_done)
        done.setOnClickListener {
            val intent = Intent(this,SaleActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}