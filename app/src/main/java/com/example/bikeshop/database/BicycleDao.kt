package com.example.bikeshop.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bikeshop.models.Bicycle
import kotlinx.coroutines.flow.Flow

@Dao
interface BicycleDao
{
    @Insert
    suspend fun insertBike(bike : Bicycle)

    @Query("SELECT * FROM bicycle_table")
    fun getAllBikes() : Flow<List<Bicycle>>

}