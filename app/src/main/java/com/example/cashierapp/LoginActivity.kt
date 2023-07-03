package com.example.cashierapp

import android.content.Intent
import android.net.nsd.NsdManager.RegistrationListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.txt_l5

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtRegisListener()
    }

    private fun txtRegisListener(){
        txt_l5.setOnClickListener {
            startActivity(Intent(this,RegisActivity::class.java))
        }
    }

}