package com.example.cashierapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cashierapp.adapter.ItemAdapter
import com.example.cashierapp.entity.AppDatabase
import com.example.cashierapp.entity.Sale
import com.example.cashierapp.entity.SaleItemCrossRef


class SaleActivity : AppCompatActivity() {
    private lateinit var btnBack: ImageView
    private lateinit var btnAdd: Button
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sale)
        initComponents()
        val idUser = intent.getIntExtra("idUser", 0)

        val db = AppDatabase.getDatabase(this)
        val itemDao = db.itemDao()
        val saleDao = db.saleDao()
        val items= itemDao.getAllItem()
        val crossRefs = arrayListOf<SaleItemCrossRef>()


        val adapter = ItemAdapter(items)
        val sale = Sale(0,idUser,"2020")
        saleDao.insertSale(sale)
        val ids = saleDao.getAllSales()
        var id= ids[0].saleID
        var sub: Long
        Log.println(Log.INFO, "BARANG","${id}")
        adapter.onItemClick = {
            val inputEditTextField = EditText(this)
            val dialog = AlertDialog.Builder(this)
                .setTitle("Jumlah")
                .setMessage("Masukan banyak barang")
                .setView(inputEditTextField)
                .setPositiveButton("OK") { _, _ ->
                    val editTextInput = inputEditTextField .text.toString()
                    var qty = editTextInput.toInt()
                    sub = qty.toLong() * it.itemPrice
                    val crossRef = SaleItemCrossRef(id, it.itemID, qty, sub)
                    crossRefs.add(crossRef)
                    Log.println(Log.INFO,"INPUT","editext value is: $editTextInput")
                    Log.println(Log.INFO, "BARANG","${crossRef.saleID} ${crossRef.itemID} ${crossRef.quantity}")

                }
                .setNegativeButton("Cancel", null)
                .create()
            dialog.show()
        }

        btnAdd.setOnClickListener {
            val intent = Intent(this, SalesFormActivity::class.java)
            for (c in crossRefs){
                saleDao.insertCrossRef(c)
                Log.println(Log.INFO, "BARANG","${c.saleID} ${c.itemID}")
            }
            val total = saleDao.sumSale(id)
            val sale = Sale(id,idUser,"2020", total)
            saleDao.updateSale(sale)

            intent.putExtra("id", id)
            intent.putExtra("total", total)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        btnBack.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initComponents(){
        btnAdd = findViewById(R.id.add_btn)
        recyclerView = findViewById(R.id.items_rv)
        btnBack = findViewById(R.id.back_btn)
    }
}