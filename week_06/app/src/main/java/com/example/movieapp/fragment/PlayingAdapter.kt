package com.example.movieapp.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.modal.Movie
import com.example.movieapp.databinding.MovieItemBinding
import com.example.movieapp.databinding.MvItemBinding

class PlayingAdapter : ListAdapter<Movie, PlayingAdapter.MovieVH>(MovieDiffUtilCallback()) {

    class MovieDiffUtilCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    class MovieVH private constructor(var binding: MvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): MovieVH {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MvItemBinding.inflate(layoutInflater, parent, false)
                return MovieVH(binding)
            }
        }

        fun binding(item: Movie) {
            binding.textView.text = item.title?.trim()
            binding.textView2.text = item.overview?.trim()
            val urlImage = "https://image.tmdb.org/t/p/w500${item.posterPath}"
            Glide.with(itemView.context).load(urlImage)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        return MovieVH.from(parent)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        val movie = getItem(position)
        holder.binding(movie)
    }
}