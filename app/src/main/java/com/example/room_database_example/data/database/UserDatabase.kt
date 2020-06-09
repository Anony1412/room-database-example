package com.example.room_database_example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room_database_example.data.dao.UserDao
import com.example.room_database_example.data.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private const val DATABASE_NAME = "room-database-example"

        private var instance: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase =
            instance ?: Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                DATABASE_NAME
            ).allowMainThreadQueries().build().also { instance = it }
    }
}
