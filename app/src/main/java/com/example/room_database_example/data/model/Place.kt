package com.example.room_database_example.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.room_database_example.data.model.Place.Companion.TABLE_NAME

//@Entity(tableName = TABLE_NAME)
data class Place(
    @PrimaryKey(autoGenerate = true) val place_id: Int?,
    @ColumnInfo(name = PLACE_NAME) var place_name: String?
) {
    companion object {
        const val TABLE_NAME = "tbl_place"
        private const val PLACE_NAME = "place_name"
    }
}
