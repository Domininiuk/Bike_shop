package com.example.bikeshop.viewmodels

import androidx.lifecycle.*
import com.example.bikeshop.adapters.DisplayBasketAdapter
import com.example.bikeshop.database.BicycleRepository
import com.example.bikeshop.models.Bicycle
import com.example.bikeshop.singletons.Basket
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import java.util.*

class DisplayBasketViewModel(private val bicycleRepository : BicycleRepository) : ViewModel()
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



    fun removeBicycleFromBasket(index : Int)
    {
        basket.removeFromBasket(index)
    }

    class DisplayBasketViewModelFactory(private val bicycleRepository: BicycleRepository): ViewModelProvider.Factory
    {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(DisplayBasketViewModel::class.java))
            {
                @Suppress("UNCHECKED_CAST")
                return DisplayBasketViewModel(bicycleRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}