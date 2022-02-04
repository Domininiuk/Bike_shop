package com.example.bikeshop.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bikeshop.models.BasketItem
import com.example.bikeshop.singletons.Basket
import kotlinx.coroutines.flow.Flow

@Dao
interface BasketDao
{

    @Query("SELECT * FROM basket_table")
    fun getAllBasketItems() : Flow<List<BasketItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItemToBasket (basketItem : BasketItem)

    suspend fun removeItemFromBasket()
}