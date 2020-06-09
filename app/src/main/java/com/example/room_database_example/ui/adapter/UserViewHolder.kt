package com.example.room_database_example.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.room_database_example.data.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bind(user: User) {
        itemView.apply {
            textUsername.text = user.name
            textUserPlace.text = user.place.place_name
        }
    }
}
