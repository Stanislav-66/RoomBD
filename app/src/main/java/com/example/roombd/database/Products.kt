package com.example.roombd.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class Products(
    @PrimaryKey(autoGenerate = true)
    val Id : Int? = null,
    val name : String,
    val count : Int,
    val describe : String
)
