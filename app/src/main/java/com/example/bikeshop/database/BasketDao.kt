package com.example.bikeshop.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bikeshop.models.BasketItem

@Dao
interface BasketDao
{

    @Query("SELECT * FROM basket_table")
    suspend fun getAllBasketItems()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItemToBasket (basket : BasketItem)

    suspend fun removeItemFromBasket()
}