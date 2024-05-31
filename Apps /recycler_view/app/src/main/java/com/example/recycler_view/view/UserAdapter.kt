package com.example.recycler_view.view

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view.R

class UserAdapter() : RecyclerView.Adapter<UserAdapter.UserViewHolder>()
{

    inner class UserViewHolder(val v:View): RecyclerView.ViewHolder(v){
        val name = v.findViewById<TextView>(R.id.mTitle)
        val mbNum = v.findViewById<TextView>(R.id.mSubTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}