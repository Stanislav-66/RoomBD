package com.example.roombd.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class, Products::class], version = 1)
abstract class BD : RoomDatabase()
{
    abstract val daoProducts:DaoProducts
    abstract val daoUsers:DaoUsers
    companion object{
        fun GetDB(context: Context) : BD
        {
            return Room.databaseBuilder(
                context,
                BD::class.java,
                "BD"
            ).build()
        }
    }
}