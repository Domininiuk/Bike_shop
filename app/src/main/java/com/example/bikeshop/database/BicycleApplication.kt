package com.example.bikeshop.database

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BicycleApplication : Application(){
    private val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {BicycleRoomDatabase.getDatabase(this, applicationScope)}
    val bicycleRepository by lazy {BicycleRepository(database.BicycleDao())}
}