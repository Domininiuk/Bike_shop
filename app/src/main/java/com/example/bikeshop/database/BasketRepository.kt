package com.example.bikeshop.database

import com.example.bikeshop.models.BasketItem
import com.example.bikeshop.models.Bicycle
import kotlinx.coroutines.flow.Flow

class BasketRepository(private val basketDao: BasketDao) {

    val allBasketItems: Flow<List<BasketItem>> = basketDao.getAllBasketItems()


    suspend fun insertBasketItem(basketItem: BasketItem)
    {
        basketDao.addItemToBasket(basketItem)
    }

}