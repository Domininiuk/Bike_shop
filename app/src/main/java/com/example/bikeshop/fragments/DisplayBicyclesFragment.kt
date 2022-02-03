package com.example.bikeshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.bikeshop.database.BicycleApplication
import com.example.bikeshop.database.BicycleRoomDatabase
import com.example.bikeshop.viewmodels.DisplayBicyclesViewModel
import com.example.bikeshop.viewmodels.DisplayBicyclesViewModelFactory

class DisplayBicyclesFragment : Fragment()
{

    private val viewModel : DisplayBicyclesViewModel by viewModels{
        DisplayBicyclesViewModelFactory((requireActivity().application as BicycleApplication).repository)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}