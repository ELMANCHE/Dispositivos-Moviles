package com.example.recyclerview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.potaxio

class potaxioAdapter(val potaxioList: List<potaxio>): RecyclerView.Adapter<potaxioViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): potaxioViewHolder {


    }

    override fun getItemCount(): Int = potaxioList.size

    override fun onBindViewHolder(holder: potaxioViewHolder, position: Int) {

    }
}