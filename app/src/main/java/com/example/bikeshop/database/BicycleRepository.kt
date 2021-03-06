package com.example.bikeshop.database

import com.example.bikeshop.models.Bicycle
import kotlinx.coroutines.flow.Flow

class BicycleRepository(private val bicycleDao: BicycleDao)
{
    val allBikes : Flow<List<Bicycle>> = bicycleDao.getAllBikes()


}