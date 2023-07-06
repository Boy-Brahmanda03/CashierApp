package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.cashierapp.entity.AppDatabase
import com.example.cashierapp.entity.User

class EditprofileActivity : AppCompatActivity() {
    private lateinit var ed_nama: EditText
    private lateinit var ed_email: EditText
    private lateinit var ed_telepon: EditText
    private lateinit var edit_profil: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editprofile)

        val email = intent.getStringExtra("email")!!

        val db = AppDatabase.getDatabase(this)
        val userDao = db.userDao()
        val user = userDao.getUser(email)

        val editNama=findViewById<EditText>(R.id.ed_nama)
        val editEmail =findViewById<EditText>(R.id.ed_email)
        val editTelepon =findViewById<EditText>(R.id.ed_telepon)

        editNama.setText(user.userName)
        editEmail.setText(user.email)
        editTelepon.setText(user.telepon)

        val btnEdit = findViewById<Button>(R.id.edit_profil)
        btnEdit.setOnClickListener {
            val name = editNama.text.toString()
            val email = editEmail.text.toString()
            val telepon = editTelepon.text.toString()

            val newUser = User(user.userID,name,email,telepon,user.password)

            userDao.updateProfile(newUser)
            Toast.makeText(this, "Profile Berhasil DiUpdate", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
            finish()
        }

        val btnBack = findViewById<ImageView>(R.id.img_r1)
        btnBack.setOnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

