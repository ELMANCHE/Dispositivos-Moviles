package com.example.recycler_view.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view.R
import com.example.recycler_view.model.UserData

class UserAdapter(val c: Context,val userlist:ArrayList<UserData>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>()
{

    inner class UserViewHolder(val v:View): RecyclerView.ViewHolder(v){
        val name = v.findViewById<TextView>(R.id.mTitle)
        val mbNum = v.findViewById<TextView>(R.id.mSubTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.lista_items,parent,false)
        return UserViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val newList = userlist[position]
        holder.name.text = newList.userName
        holder.mbNum.text = newList.userMb
    }
}