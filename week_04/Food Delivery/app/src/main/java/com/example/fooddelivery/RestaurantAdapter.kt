package com.example.fooddelivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class RestaurantAdapter : ListAdapter<Restaurant, RestaurantAdapter.ResViewHolder>(RestaurantDiffUtil()) {

    class RestaurantDiffUtil : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResViewHolder {
        return ResViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ResViewHolder, position: Int) {
        val res = getItem(position)
        holder.bindData(res)
    }


    class ResViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object {
            fun from(parent: ViewGroup) : ResViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.activity_restaurant, parent, false)
                return ResViewHolder(view)
            }
        }

        fun bindData(res: Restaurant) {
            val resName = itemView.findViewById<TextView>(R.id.restaurant_name)
            val resAddress = itemView.findViewById<TextView>(R.id.restaurant_address)
            val resAvatar = itemView.findViewById<ImageView>(R.id.restaurant_avatar)

//            resName.text = res.name.toString()
//            resAddress.text = res.address.toString()
//            resAvatar.setImageResource(res.avatar)
        }
    }
}