package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fooddelivery.databinding.FragmentOnBoardingOneBinding
import com.example.fooddelivery.databinding.FragmentOnBoardingTwoBinding


class OnBoardingTwoFragment : Fragment() {
    lateinit var binding : FragmentOnBoardingTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardingTwoBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView17.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_onBoardingTwoFragment_to_onBoardingThreeFragment)
        }
    }
}