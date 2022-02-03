package com.example.bikeshop.database

import androidx.annotation.WorkerThread
import com.example.bikeshop.models.Bicycle
import kotlinx.coroutines.flow.Flow

class BicycleRepository(bicycleDao: BicycleDao)
{
    val allBikes : Flow<List<Bicycle>> = bicycleDao.getAllBikes()

}