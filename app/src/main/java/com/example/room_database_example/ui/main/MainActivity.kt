package com.example.room_database_example.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.room_database_example.R
import com.example.room_database_example.data.database.UserDatabase
import com.example.room_database_example.data.model.Place
import com.example.room_database_example.data.model.User
import com.example.room_database_example.ui.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var userDatabase: UserDatabase? = null
    private val userAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDatabase()
        initListener()
    }

    private fun initListener() {
        buttonShowUsers.setOnClickListener(this)
        buttonInsert.setOnClickListener(this)
        buttonUpdate.setOnClickListener(this)
        buttonDelete.setOnClickListener(this)
    }

    private fun initDatabase() {
        userDatabase = UserDatabase.getInstance(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonShowUsers -> showAllUsers()
            R.id.buttonInsert -> insertUser()
            R.id.buttonUpdate -> updateUser()
            R.id.buttonDelete -> deleteUser()
        }
    }

    private fun deleteUser() {
        val user = userAdapter.getItem(5)
        userDatabase?.userDao()?.deleteUser(user)
        userAdapter.deleteItem(user)
    }

    private fun updateUser() {
        val user = userAdapter.getItem(5)
        user.name = "haha"
        user.place.place_name = "Da Nang"
        userDatabase?.userDao()?.updateUser(user)
        userAdapter.updateData()
    }

    private fun insertUser() {
        val user = User(
            null,
            "User ${Random(100)}",
            Place(null, "Ha Noi")
        )
        userDatabase?.userDao()?.insertUser(user)
        userAdapter.insertItem(user)
    }

    private fun showAllUsers() {
        val users = userDatabase?.userDao()?.getAllUsers()
        users?.let { recyclerViewUser.adapter = userAdapter.apply { setData(it) } }
    }
}
