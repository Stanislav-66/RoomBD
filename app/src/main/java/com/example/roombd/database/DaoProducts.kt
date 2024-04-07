package com.example.roombd.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface DaoProducts
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(products: Products)

    @Delete
    suspend fun delete(products: Products)

    @Query("Select * from Products")
    fun getproducts() : Flow<List<Products>>
}