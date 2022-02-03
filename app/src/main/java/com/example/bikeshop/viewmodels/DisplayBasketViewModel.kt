package com.example.bikeshop.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bikeshop.models.Bicycle
import com.example.bikeshop.singletons.Basket
import java.lang.IllegalArgumentException

class DisplayBasketViewModel : ViewModel()
{
    val basket = Basket

    val allBicycles = basket.bicyclesAddedToBasket


    fun removeBicycleFromBasket()
    {

    }

    class DisplayBasketViewModelFactory() : ViewModelProvider.Factory
    {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(DisplayBasketViewModel::class.java))
            {
                @Suppress("UNCHECKED_CAST")
                return DisplayBasketViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}