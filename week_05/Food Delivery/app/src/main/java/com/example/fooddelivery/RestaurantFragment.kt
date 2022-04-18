package com.example.fooddelivery

import android.os.Bundle
import android.view.*
import androidx.datastore.dataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.databinding.FragmentOnBoardingOneBinding
import com.example.fooddelivery.databinding.FragmentRestaurantBinding

class RestaurantFragment : Fragment() {
    private lateinit var binding1:FragmentRestaurantBinding
    private lateinit var viewModel: RestaurantViewModal
    lateinit var adapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding1 = FragmentRestaurantBinding.inflate(inflater, container, false)
        return binding1.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RestaurantViewModal::class.java)
        binding1.imvProfileCorner.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_restaurantFragment_to_profileFragment)
        }

        adapter =RestaurantAdapter()
        val lm =LinearLayoutManager(this@RestaurantFragment.requireContext())
        binding1.rvRestaurant.layoutManager = lm
        binding1.rvRestaurant.adapter = adapter
        registerData()


    }
    override fun onStart() {
        super.onStart()
        viewModel.loadData()
    }


    private  fun registerData() {
        viewModel.listOfData.observe(viewLifecycleOwner){ listOfRes ->
            adapter.submitList(listOfRes)
        }
    }






}