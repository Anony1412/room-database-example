package com.example.room_database_example.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room_database_example.R
import com.example.room_database_example.data.model.User

class UserAdapter: RecyclerView.Adapter<UserViewHolder>() {

    private var users = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        )
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun setData(users: List<User>) {
        if (this.users.isNotEmpty()) this.users.clear()
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    fun updateData() = notifyDataSetChanged()

    fun insertItem(user: User) {
        users.add(user)
        notifyItemInserted(users.indexOf(user))
    }

    fun deleteItem(user: User) {
        users.remove(user)
        notifyItemRemoved(users.indexOf(user))
    }

    fun getItem(position: Int): User  = users[position]
}
