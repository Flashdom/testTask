package com.task.test.myapplicationtest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.task.test.myapplicationtest.R
import com.task.test.myapplicationtest.api.Companies

class MainAdapter(var items: List<Companies>, val onItemClicked: OnItemClicked) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name = itemView.findViewById<TextView>(R.id.name)
        private val number = itemView.findViewById<TextView>(R.id.number)
        private val picture = itemView.findViewById<ImageView>(R.id.picture)
        private val pictureString = "http://megakohz.bget.ru/test_task/"
        fun bind(item: Companies) {
            name.text = item.name
            Picasso.get().load(pictureString + item.img).into(picture)
            number.text = item.id
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    onItemClicked.onItemClicked(items[adapterPosition])
            }
        }
    }
}

interface OnItemClicked {
    fun onItemClicked(item: Companies)
}