package com.example.room_database_example.data.dao

import androidx.room.*
import com.example.room_database_example.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM ${User.TABLE_NAME}")
    fun getAllUsers(): List<User>

    @Insert
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)
}
