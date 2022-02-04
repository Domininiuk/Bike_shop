package com.example.bikeshop.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.bikeshop.database.BicycleRepository
import com.example.bikeshop.models.Bicycle
import com.example.bikeshop.singletons.Basket

class DisplayBicyclesViewModel(bicycleRepository : BicycleRepository) : ViewModel() {

    var allBikes : LiveData<List<Bicycle>> = bicycleRepository.allBikes.asLiveData()

    private var basket = Basket

    fun addBikeToBasket(bicycle: Bicycle)
    {
        basket.addToBasket(bicycle)


    }

}

class DisplayBicyclesViewModelFactory(private val bicycleRepository: BicycleRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DisplayBicyclesViewModel::class.java))
        {
            @Suppress("UNCHECKED_CAST")
            return DisplayBicyclesViewModel(bicycleRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}