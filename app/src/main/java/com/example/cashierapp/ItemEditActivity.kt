package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cashierapp.entity.AppDatabase
import com.example.cashierapp.entity.Item

class ItemEditActivity : AppCompatActivity() {
    private lateinit var btnSimpan: Button
    private lateinit var btnDelete: Button
    private lateinit var etNameItem: EditText
    private lateinit var etPriceItem: EditText
    private lateinit var etStockItem: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_edit)
        initComponents()
        val db = AppDatabase.getDatabase(this)
        val dao = db.itemDao()
        val id = intent.getIntExtra("id", 0)
        val name = intent.getStringExtra("nama").toString()
        val stok = intent.getStringExtra("stok")
        val price = intent.getStringExtra("harga")
        etNameItem.setText(name)
        etPriceItem.setText(price)
        etStockItem.setText(stok)

        btnSimpan.setOnClickListener {
            val name = etNameItem.text.toString()
            val price =  etPriceItem.text.toString()
            val stok = etStockItem.text.toString()
            val cek = checkInput(name, stok, price)
            if (!cek){
                Toast.makeText(this, "ISI SEMUA KOLOM", Toast.LENGTH_LONG).show()
            } else {
                val item = Item(id,name, stok.toInt(), price.toLong())
                dao.updateItem(item)
                Toast.makeText(this, "DATA BERHASIL DIUPDATE", Toast.LENGTH_LONG).show()
                val intent = Intent(this, ItemActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        btnDelete.setOnClickListener {
            val name = etNameItem.text.toString()
            val price =  etPriceItem.text.toString()
            val stok = etStockItem.text.toString()

            val item = Item(id,name, stok.toInt(), price.toLong())
            dao.deleteItem(item)
            Toast.makeText(this, "DATA BERHASIL DIHAPUS", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ItemActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun checkInput(name: String, stok: String, price: String): Boolean{
        if (name.isEmpty() && stok.isEmpty() && price.isEmpty()){
            return false
        }
        else if (name.isEmpty()){
            return false
        }
        else if (stok.isEmpty()){
            return false
        }
        else if (price.isEmpty()){
            return false
        }
        return true
    }

    private fun initComponents(){
        btnSimpan = findViewById(R.id.save_btn)
        btnDelete = findViewById(R.id.btn_delete)
        etNameItem = findViewById(R.id.namabarang_et)
        etStockItem = findViewById(R.id.stokbarang_et)
        etPriceItem = findViewById(R.id.hargabarang_et)
    }
}