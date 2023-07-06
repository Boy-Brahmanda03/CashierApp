package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.cashierapp.entity.AppDatabase


class ForgetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        val db=AppDatabase.getDatabase(this)
        val userDao=db.userDao()

        val emailet= findViewById<EditText>(R.id.edt_forgetemail)
        val passet= findViewById<EditText>(R.id.edt_forgetpass)
        val repasset= findViewById<EditText>(R.id.edt_forgetrepass)

        val btnKonfirm= findViewById<Button>(R.id.btn_forgetkonfirm)
        btnKonfirm.setOnClickListener {
            val email= emailet.text.toString()
            val password= passet.text.toString()
            val repassword= repasset.text.toString()

            if (password == repassword) {
                userDao.updateUser(email, password)
                Log.println(Log.INFO,"TEST", "MASHOK $email $password $repassword")
                Toast.makeText(this, "PASSWORD BERHASIL DIUPDATE", Toast.LENGTH_LONG).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "PASSWORD TIDAK SAMA", Toast.LENGTH_LONG).show()
            }

        }

        val btnBack = findViewById<ImageView>(R.id.img_forget)
        btnBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }
}