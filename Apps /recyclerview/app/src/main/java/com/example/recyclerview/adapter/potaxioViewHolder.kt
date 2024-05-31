package com.example.recyclerview.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerview.R
import com.example.recyclerview.potaxio

class potaxioViewHolder(view: View):RecyclerView.ViewHolder(view)  {

    val potaxio = view.findViewById<TextView>(R.id.tvPotaxioName)
    val realName = view.findViewById<TextView>(R.id.tvRealName)
    val Publisher = view.findViewById<TextView>(R.id.tvPublisher)
    val photo = view.findViewById<ImageView>(R.id.ivPotaxie)





    fun render(potaxioModel: potaxio){
        potaxio.text = potaxioModel.potaxio
        realName.text = potaxioModel.realName
        Publisher.text = potaxioModel.publisher

    }
}