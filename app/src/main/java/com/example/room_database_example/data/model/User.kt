package com.example.room_database_example.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.room_database_example.data.model.User.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = NAME) var name: String?,
    @Embedded val place: Place
) {

    override fun toString(): String = "$id - $name - ${place.place_name}"

    companion object {
        const val TABLE_NAME = "tbl_user"
        private const val NAME = "user_name"
    }
}
