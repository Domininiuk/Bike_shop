package com.example.bikeshop.singletons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bikeshop.models.Bicycle

object Basket
{
    var bicyclesAddedToBasket = MutableLiveData(mutableListOf<Bicycle>())


    // If a bicycle is already in the basket,
    // simply increment the quantity by 1

    fun addToBasket(bike : Bicycle)
    {
        bicyclesAddedToBasket.value?.add(bike)
    }
    fun removeFromBasket(bicycle: Bicycle)
    {
        //bicyclesAddedToBasket.value.removeIf { it == bicycle }
    }
}