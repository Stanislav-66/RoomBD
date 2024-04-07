package com.example.roombd.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val Id : Int? = null,
    @ColumnInfo(name = "login")
    val login : String,
    @ColumnInfo(name = "password")
    val password : String
)
