package com.example.bikeshop.viewmodels

import androidx.lifecycle.*
import com.example.bikeshop.database.BicycleRepository
import com.example.bikeshop.models.Bicycle
import com.example.bikeshop.singletons.Basket
import java.lang.IllegalArgumentException

class DisplayBicyclesViewModel(private val repository : BicycleRepository) : ViewModel() {

    var allBikes : LiveData<List<Bicycle>> = repository.allBikes.asLiveData()
    var allBikesObserver = Observer<List<Bicycle>>{ it


    }

}

class DisplayBicyclesViewModelFactory(private val repository: BicycleRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DisplayBicyclesViewModel::class.java))
        {
            @Suppress("UNCHECKED_CAST")
            return DisplayBicyclesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}