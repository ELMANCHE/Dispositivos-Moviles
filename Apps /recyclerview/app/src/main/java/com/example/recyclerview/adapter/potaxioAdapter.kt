package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.potaxio

class potaxioAdapter(private val potaxioList: List<potaxio>): RecyclerView.Adapter<potaxioViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): potaxioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return potaxioViewHolder(layoutInflater.inflate(R.layout.item_potaxio, parent, false))


    }

    override fun getItemCount(): Int = potaxioList.size

    override fun onBindViewHolder(holder: potaxioViewHolder, position: Int) {

    }
}