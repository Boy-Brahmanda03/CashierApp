package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cashierapp.entity.AppDatabase
import com.example.cashierapp.entity.User

class RegisterActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etTelepon: EditText
    private lateinit var etPass: EditText
    private lateinit var etRePass: EditText
    private lateinit var btnRegister: Button
    private lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initComponents()
        val db = AppDatabase.getDatabase(this).userDao()

        btnRegister.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val telepon = etTelepon.text.toString()
            val pass = etPass.text.toString()
            val repass = etRePass.text.toString()

            val cek = checkPass(pass, repass)
            if (cek){
                val user = User(0, name, email, telepon, repass)
                db.insertUser(user)
                Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show()
            }
        }
        tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun checkPass(pass: String, repass: String): Boolean {
        return pass == repass
    }

    private fun initComponents(){
        etName = findViewById(R.id.edt_nama)
        etEmail = findViewById(R.id.edt_email)
        etTelepon = findViewById(R.id.edt_telepon)
        etPass = findViewById(R.id.edt_password)
        etRePass = findViewById(R.id.edt_repassword)
        btnRegister = findViewById(R.id.btn_r1)
        tvLogin = findViewById(R.id.txt_r3)
    }
}