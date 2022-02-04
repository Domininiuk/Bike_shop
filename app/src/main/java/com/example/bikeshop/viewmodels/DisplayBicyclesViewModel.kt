package com.example.bikeshop.viewmodels

import androidx.lifecycle.*
import com.example.bikeshop.database.BasketRepository
import com.example.bikeshop.database.BicycleRepository
import com.example.bikeshop.models.Bicycle
import com.example.bikeshop.singletons.Basket
import java.lang.IllegalArgumentException

class DisplayBicyclesViewModel(private val bicycleRepository : BicycleRepository, private val basketRepository: BasketRepository) : ViewModel() {

    var allBikes : LiveData<List<Bicycle>> = bicycleRepository.allBikes.asLiveData()

    var basket = Basket

    fun addBikeToBasket(bicycle: Bicycle)
    {
        basket.addToBasket(bicycle)
       // basketRepository.allBasketItems
    }

}

class DisplayBicyclesViewModelFactory(private val bicycleRepository: BicycleRepository, private val basketRepository: BasketRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DisplayBicyclesViewModel::class.java))
        {
            @Suppress("UNCHECKED_CAST")
            return DisplayBicyclesViewModel(bicycleRepository, basketRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}