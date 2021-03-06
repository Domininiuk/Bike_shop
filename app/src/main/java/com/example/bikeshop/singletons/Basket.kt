package com.example.bikeshop.singletons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bikeshop.models.Bicycle

object Basket
{
    var bicyclesAddedToBasket = MutableLiveData(mutableListOf<Bicycle>())



    fun addToBasket(bike : Bicycle)
    {
        bicyclesAddedToBasket.value?.add(bike)
    }
    fun removeFromBasket(index : Int)
    {
        if(index >= 0)
        {
            bicyclesAddedToBasket.value?.removeAt(index)
        }
    }
}