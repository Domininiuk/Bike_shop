package com.example.bikeshop.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bikeshop.database.BicycleRepository
import com.example.bikeshop.models.Bicycle
import com.example.bikeshop.singletons.Basket

class DisplayBicyclesViewModel(private val repository : BicycleRepository) : ViewModel() {

    var allBikes : LiveData<List<Bicycle>> = repository.allBikes.asLiveData()

}