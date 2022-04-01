package com.example.fooddelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
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

        setUpLinearList()
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

    private fun setUpLinearList() {
        adapter = RestaurantAdapter()
        val lm = LinearLayoutManager(this)
        binding1.rvRestaurant.layoutManager = lm
        binding1.rvRestaurant.adapter = adapter
    }
    private fun setUpGridList() {
        adapter = RestaurantAdapter()
        val lm = GridLayoutManager(this,2)
        binding1.rvRestaurant.layoutManager = lm
        binding1.rvRestaurant.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            R.id.linearmenu ->{
                setUpLinearList()
                registerData()
                true
            }
            R.id.gridmenu->{
                setUpGridList()
                registerData()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}