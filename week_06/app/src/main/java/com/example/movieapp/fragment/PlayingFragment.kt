package com.example.movieapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentPlayingBinding
import com.example.movieapp.databinding.FragmentRateBinding
import com.example.movieapp.databinding.FragmentTopratedBinding


class PlayingFragment : Fragment() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_toprated, container, false)
//    }
//}

    lateinit var vm: PlayingVM
    lateinit var adapter: PlayingAdapter
    lateinit var binding: FragmentPlayingBinding
    var flag : Boolean= true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayingBinding.inflate(inflater,container,false)
        vm = ViewModelProvider(this).get(PlayingVM::class.java)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpMovieList()
        /*binding.buttonlist.setOnClickListener {
            binding.rv.layoutManager = LinearLayoutManager(context)

        }

        binding.buttongrid.setOnClickListener {
            binding.rv.layoutManager = GridLayoutManager(context, 2)
        }*/

        registerMovieList()
        registerErrorList()
    }
    override fun onStart() {
        super.onStart()
        vm.getNowPlaying()
    }
    private fun setUpMovieList() {
        adapter = PlayingAdapter()
        val lm = LinearLayoutManager(context)
        binding.rv.layoutManager = lm
        binding.rv.adapter = adapter
    }

    private fun registerMovieList() {
        vm.movieData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
    private fun registerErrorList() {
        vm.errEvent.observe(viewLifecycleOwner){
//            show dialog
        }
    }
}

