package com.example.cashierapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cashierapp.entity.AppDatabase
import com.example.cashierapp.entity.Item

class ItemAddActivity : AppCompatActivity() {
    private lateinit var btnSimpan: Button
    private lateinit var etNameItem: EditText
    private lateinit var etPriceItem: EditText
    private lateinit var etStockItem: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_add)
        val db = AppDatabase.getDatabase(this)
        initComponents()
        btnSimpan.setOnClickListener {
            Log.println(Log.INFO, "CHECK", "PENCET")
            val name = etNameItem.text.toString()
            val stok = etStockItem.text.toString()
            val price = etPriceItem.text.toString()
            val cek = checkInput(name, stok, price)
            if (!cek){
                Toast.makeText(this, "ISI SEMUA KOLOM", Toast.LENGTH_SHORT).show()
            } else {
                val item = Item(0,name, stok.toInt(), price.toLong())
                Log.println(Log.INFO, "CHECK", "PENCET ${item.itemName} ${item.itemStock}")
                db.itemDao().insertItem(item)
                val intent = Intent(this, ItemActivity::class.java)
                startActivity(intent)
            }
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
        etNameItem = findViewById(R.id.namabarang_et)
        etStockItem = findViewById(R.id.stokbarang_et)
        etPriceItem = findViewById(R.id.hargabarang_et)
    }
}