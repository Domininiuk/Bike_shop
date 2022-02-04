package com.example.bikeshop.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.bikeshop.models.BasketItem
import com.example.bikeshop.models.Bicycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Bicycle::class, BasketItem::class], version = 1, exportSchema = false)
abstract class  BicycleRoomDatabase : RoomDatabase() {
    abstract fun BicycleDao(): BicycleDao
    abstract fun BasketDao() : BasketDao
    companion object
    {


    @Volatile
    private var INSTANCE: BicycleRoomDatabase? = null

    fun getDatabase(
        context: Context,
        scope: CoroutineScope
    ): BicycleRoomDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                BicycleRoomDatabase::class.java,
                "bicycle_database"
            )
                .fallbackToDestructiveMigration()
                .addCallback(BicycleDatabaseCallback(scope))
                .build()
            INSTANCE = instance
            instance
        }
    }


    private class BicycleDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    addDefaultValues(database.BicycleDao())
                }

            }

        }
    }

        suspend fun addDefaultValues(bicycleDao : BicycleDao)
        {
            val bikeOne = Bicycle(name = "XC-1W", price = 999, colour = "Purple", brand = "OXFELD")
            val bikeTwo = Bicycle(name = "XC 879", price = 4099, colour = "Red", brand = "SUPERIOR")
            val bikeThree = Bicycle(name = "Belleco", price = 1449, colour = "White", brand = "ROMET ")
            val bikeFour = Bicycle(name = "F.L.Y. 27", price = 2699, colour = "Pink", brand = "SUPERIOR  ")
            bicycleDao.insertBike(bikeOne)
            bicycleDao.insertBike(bikeTwo)
            bicycleDao.insertBike(bikeThree)
            bicycleDao.insertBike(bikeFour)
        }
}
}