package com.example.roombd.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy


@Dao
interface DaoClients
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(clients: Clients)

    @Delete
    suspend fun delete(clients: Clients)
}