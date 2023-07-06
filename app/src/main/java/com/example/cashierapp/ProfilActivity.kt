package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.cashierapp.R
import com.example.cashierapp.entity.AppDatabase

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        val email = intent.getStringExtra("email")!!

        val db = AppDatabase.getDatabase(this)
        val userDao = db.userDao()
        val user = userDao.getUser(email)

        val nametv = findViewById<TextView>(R.id.txtNama)
        nametv.text = user.userName

        val emailtv = findViewById<TextView>(R.id.txtEmail)
        emailtv.text = user.email

        val telepontv = findViewById<TextView>(R.id.txtTelepon)
        telepontv.text = user.telepon

        val editBtn = findViewById<Button>(R.id.btnEditprofil)
        editBtn.setOnClickListener {
            val intent = Intent (this, EditprofileActivity::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }


    }
}