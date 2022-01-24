package com.example.appkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appkotlin.R
import com.example.appkotlin.model.User

class UserAdapter(private val users: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users[position]

        (holder as ContactViewHolder).apply {
            tv_username.text = user.username
            tv_password.text = user.password
        }
    }

    override fun getItemCount(): Int = users.size

    class ContactViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tv_username: TextView = view.findViewById(R.id.tv_username)
        val tv_password: TextView = view.findViewById(R.id.tv_password)
    }
}