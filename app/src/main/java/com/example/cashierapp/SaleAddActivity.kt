package com.example.cashierapp

import android.content.Intent
import android.icu.util.UniversalTimeScale.toLong
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class SaleAddActivity : AppCompatActivity() {
    private lateinit var itemName: TextView
    private lateinit var stockTv: TextView
    private lateinit var priceTv: TextView
    private lateinit var add: ImageView
    private lateinit var min: ImageView
    private lateinit var qtyTv: TextView
    private lateinit var backBtn: ImageView
    private lateinit var saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sale_add)
        initComponents()
        val name = intent.getStringExtra("nama").toString()
        val stok = intent.getStringExtra("stok")
        val price = intent.getStringExtra("harga")


        itemName.text = name
        stockTv.text = stok
        priceTv.text = price

        var qty = qtyTv.text.toString().toInt()

        //utk tambah qty
        add.setOnClickListener {
            val tmp = qty++
            qtyTv.text = tmp.toString()
        }

        //utk kurangi qty
        min.setOnClickListener {
            val min = 0
            var tmp = qty
            if (tmp <= min ) {
                tmp = 0
            } else {
                tmp = qty--
            }
            qtyTv.text = tmp.toString()
        }

        //untuk kembali
        backBtn.setOnClickListener {
            val intent = Intent(this, SaleActivity::class.java)
            startActivity(intent)
        }

        saveBtn.setOnClickListener {
            val tmpp = price?.toLong()
            val subTotal = qty * tmpp!!


            val builder1 = AlertDialog.Builder(this)
            builder1.setMessage("Tambah lagi?")
            builder1.setCancelable(true)
            builder1.setPositiveButton(
                "Yes"
            ) { dialog, id ->
                val intent = Intent(this, SaleActivity::class.java)
                startActivity(intent)
            }

            builder1.setNegativeButton(
                "No"
            ) { dialog, id ->
                Toast.makeText(this, "$subTotal", Toast.LENGTH_SHORT).show()
            }

            val alert11 = builder1.create()
            alert11.show()
        }
    }


    fun initComponents(){
        itemName = findViewById(R.id.itemname_tv)
        add = findViewById(R.id.add_qty)
        min = findViewById(R.id.min_qty)
        qtyTv = findViewById(R.id.qty_tv)
        stockTv = findViewById(R.id.itemstock_tv)
        priceTv = findViewById(R.id.itemprice_tv)
        backBtn = findViewById(R.id.back_btn)
        saveBtn = findViewById(R.id.add_btn)
    }
}