package com.example.movieapp.screens.home

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.MovieItemBinding
import com.example.movieapp.modal.Movie

class MovieAdapter(val mListener: OnItemClickListener) : ListAdapter<Movie, MovieAdapter.MovieVH>(MovieDiffUtilCallback()) {

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
    class MovieDiffUtilCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    class MovieVH private constructor(var binding: MovieItemBinding, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup, listener: OnItemClickListener): MovieVH {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieItemBinding.inflate(layoutInflater, parent, false)
                return MovieVH(binding,listener)
            }
        }
        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

        fun binding(item: Movie) {
            binding.textView.text = item.title?.trim()
            binding.textView.ellipsize = TextUtils.TruncateAt.MARQUEE
            binding.textView.isSelected = true
            binding.textView2.text = item.overview?.trim()
            binding.textView2.ellipsize = TextUtils.TruncateAt.MARQUEE
            binding.textView2.isSelected = true

            val urlImage = "https://image.tmdb.org/t/p/w500${item.posterPath}"
            Glide.with(itemView.context).load(urlImage)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        return MovieVH.from(parent,mListener)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        val movie = getItem(position)
        holder.binding(movie)
    }
    fun getMovie(position: Int): Movie {
        return getItem(position);
    }
}