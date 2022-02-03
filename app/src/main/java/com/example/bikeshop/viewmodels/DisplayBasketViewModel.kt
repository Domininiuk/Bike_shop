package com.example.bikeshop.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bikeshop.singletons.Basket
import java.lang.IllegalArgumentException

class DisplayBasketViewModel : ViewModel()
{
    val basket = Basket

    val allBasketItems = basket.bicyclesAddedToBasket
    private var totalPrice : Int = 0


    fun getTotalPrice() : Int
    {
        calculateTotalPrice()
        return totalPrice
    }
    private fun calculateTotalPrice()
    {
        resetTotalPrice()
        summarizeTotalPrice()

    }
    private fun resetTotalPrice()
    {
        totalPrice = 0
    }
    private fun summarizeTotalPrice()
    {
        for(bicycle in allBasketItems.value!!)
        {
            totalPrice += bicycle.price
        }
    }

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