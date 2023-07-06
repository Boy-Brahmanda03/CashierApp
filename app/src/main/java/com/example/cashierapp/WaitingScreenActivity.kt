package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WaitingScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waiting_screen)

        val nextSecButton =findViewById<Button>(R.id.btn_secsplash)
        nextSecButton.setOnClickListener {
            val Intent = Intent(this, LoginActivity::class.java)
            startActivity(Intent)
        }
    }
}