package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cashierapp.entity.AppDatabase

class LoginActivity : AppCompatActivity() {
    private lateinit var btnLogin: Button
    private lateinit var tvLogin: TextView
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initComponents()
        val db = AppDatabase.getDatabase(this).userDao()

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val cek = checkPass(db, email, password)
            if (cek){
                Toast.makeText(this, "BERHASIL", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "GAGAL", Toast.LENGTH_SHORT).show()
            }
        }

        tvLogin.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun checkPass(userDao: UserDao, email: String, pass: String): Boolean {
        val users = userDao.getAllUser()
        for (user in users){
            return user.email == email && user.password == pass
        }
        return false
    }

    private fun initComponents(){
        btnLogin = findViewById(R.id.btn_l1)
        tvLogin = findViewById(R.id.txt_l5)
        etEmail = findViewById(R.id.edt_l_email)
        etPassword = findViewById(R.id.edt_l_password)
    }
}