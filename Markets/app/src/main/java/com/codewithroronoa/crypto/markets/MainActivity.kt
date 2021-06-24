package com.codewithroronoa.crypto.markets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var cryptoAdapter : CryptoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        initViewModel()
    }

    private fun initRecycler() {
        val recyclerview = findViewById<RecyclerView>(R.id.crypto_view)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerview.addItemDecoration(decoration)
        cryptoAdapter = CryptoAdapter()
        recyclerview.adapter = cryptoAdapter
    }
    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getmarketListObserver().observe(this, Observer <mark>{
            if(it!=null){
                cryptoAdapter.setUpdatedData(it.markets)
            }else
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
        })
        viewModel.makeApiCall()
    }

}