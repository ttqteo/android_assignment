package com.example.movieapp.screens.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.HomeFragmentBinding
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.movieapp.modal.Movie
import com.example.movieapp.screens.home.HomeViewModel
import com.example.movieapp.screens.home.MovieAdapter


class Home : Fragment(),MovieAdapter.OnItemClickListener {
    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel : HomeViewModel
    private lateinit var adapter: MovieAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        setHasOptionsMenu(true)
        return binding.root
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

    override fun onStart() {
        super.onStart()
        viewModel.getNowPlaying()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        inflater.inflate(R.menu.options_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_listview -> {
                val lm = LinearLayoutManager(context)
                binding.rv.layoutManager = lm
            }
            R.id.action_gridview -> {
                val gm = GridLayoutManager(context,2)
                binding.rv.layoutManager = gm
            }
        }

        return super.onOptionsItemSelected(item)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpMovieList()
        registerMovieList()
        registerErrorList()
        bottomNavigation()
    }

    private fun setUpMovieList() {
        adapter = MovieAdapter(this)
        val lm = LinearLayoutManager(context)
        binding.rv.layoutManager = lm
        binding.rv.adapter = adapter
    }

    private fun registerMovieList() {
        viewModel.movieData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun registerErrorList() {
        viewModel.errEvent.observe(viewLifecycleOwner){
            //show dialog
        }
    }

    override fun onItemClick(position: Int) {
        val builder = AlertDialog.Builder(requireContext())
        val dialogLayout =layoutInflater.inflate(R.layout.detail,null)
        val tvName = dialogLayout.findViewById<TextView>(R.id.txtMovieName)
        val tvDesc = dialogLayout.findViewById<TextView>(R.id.txtMovieDescription )
        val ivImage = dialogLayout.findViewById<ImageView>(R.id.imgMovie)
        //val Background = dialogLayout.findViewById<ImageView>(R.id.background)
        val movie : Movie = adapter.getMovie(position)
        tvName.text = movie.title
        tvDesc.text = movie.overview

        val urlImage = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
        Glide.with(dialogLayout).load(urlImage).into(ivImage)
        with(builder){
            setTitle("${tvName.text}")
            setNegativeButton("Cancel"){dialog, which ->
                dialog.dismiss()
            }
            setView(dialogLayout)
            show()
        }
    }

    private fun bottomNavigation(){
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.play_bot -> {
                    // Respond to navigation item 1 click
//                    Toast.makeText(requireContext(),"Now playing clicked", Toast.LENGTH_SHORT).show()
                    viewModel.getNowPlaying()
                    true
                }
                R.id.rate_bot -> {
                    // Respond to navigation item 2 click
//                    Toast.makeText(requireContext(),"Top rating clicked", Toast.LENGTH_SHORT).show()
                    viewModel.getRatedMovie()
                    true
                }
                else -> false
            }

        }
    }
}