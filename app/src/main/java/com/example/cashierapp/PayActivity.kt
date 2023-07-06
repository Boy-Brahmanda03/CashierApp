package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cashierapp.entity.AppDatabase

class PayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        val total = intent.getLongExtra("total", 0)
        val pay = findViewById<TextView>(R.id.tv_total)
        pay.text =  "Rp. ${total.toString()}"
        val btn = findViewById<Button>(R.id.add_btn)
        btn.setOnClickListener {
            val payment = findViewById<EditText>(R.id.pay_et)
            val pays = payment.text.toString()
            Log.println(Log.INFO, "TEST",  "$pays ${pay.text}")

            val payss = pays.toLong()
            if (payss >= total ){
                val change = payss - total
                val intent = Intent(this,FinishTransaksi::class.java)
                Log.println(Log.INFO, "TEST",  "$total $change")
                intent.putExtra("change", change)
                intent.putExtra("total", total)
                startActivity(intent)
                finish()
            }
        }


//        val payss = pays.toLong()
//
//        if (payss >= total ){
//            val change = pays.toLong() - total
//            val btn = findViewById<Button>(R.id.add_btn)
//            btn.setOnClickListener {
//                val intent = Intent(this,FinishTransaksi::class.java)
//                intent.putExtra("change", change)
//                startActivity(intent)
//                finish()
//            }
//        } else {
//            Log.println(Log.INFO, "TEST", "$payss $pays")
//        }

    }
}