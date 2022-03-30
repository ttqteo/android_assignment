package com.example.fooddelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.databinding.ActivityRestaurantBinding

class RestaurantActivity : AppCompatActivity() {
    private lateinit var binding1: ActivityRestaurantBinding
    private lateinit var viewModel: RestaurantViewModal
    private lateinit var adapter : RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = DataBindingUtil.setContentView(this, R.layout.activity_restaurant)
        viewModel = ViewModelProvider(this).get(RestaurantViewModal::class.java)

        setUpList()
        registerData()

    }
    
    override fun onStart() {
        super.onStart()
        viewModel.loadData()
    }

    private  fun registerData() {
        viewModel.listOfData.observe(this){ listOfRes ->
            adapter.submitList(listOfRes)
        }
    }

    private fun setUpList() {
        adapter = RestaurantAdapter()
        val lm = LinearLayoutManager(this)
        binding1.rvRestaurant.layoutManager = lm
        binding1.rvRestaurant.adapter = adapter
    }
}