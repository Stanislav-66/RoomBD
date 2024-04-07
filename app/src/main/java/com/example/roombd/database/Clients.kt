package com.example.roombd.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Clients")
data class Clients(
    @PrimaryKey(autoGenerate = true)
    val Id : Int? = null,
    val surname : String,
    val name : String,
    val patronomic : String
)
