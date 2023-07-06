package com.example.cashierapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cashierapp.adapter.ItemAdapter
import com.example.cashierapp.adapter.SaleAdapter
import com.example.cashierapp.entity.AppDatabase
import com.example.cashierapp.entity.BuyItems
import com.example.cashierapp.entity.SaleItemCrossRef

class SalesFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales_form)
        var sID = intent.getIntExtra("id",0)
        var total = intent.getLongExtra("total", 0)

        Log.println(Log.INFO, "BARANG","$sID")

        val db = AppDatabase.getDatabase(this)
        val saleDao = db.saleDao()
        val items= saleDao.getSaleWithItems(sID)
        val cross = saleDao.getSalesDetail(sID)
        val adapter = SaleAdapter(items, cross)

        val recyclerView = findViewById<RecyclerView>(R.id.items_rv)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val textTotal = findViewById<TextView>(R.id.textTotal)
        textTotal.text = total.toString()

        val backbtn = findViewById<ImageView>(R.id.img_r1)
        backbtn.setOnClickListener {
            val intent = Intent(this, SaleActivity::class.java)
            startActivity(intent)
        }

        val finish = findViewById<Button>(R.id.add_btn)
        finish.setOnClickListener {
            val intent = Intent(this,PayActivity::class.java)
            intent.putExtra("total", total)
            startActivity(intent)
        }

    }
}