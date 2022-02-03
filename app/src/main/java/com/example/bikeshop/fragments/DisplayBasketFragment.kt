package com.example.bikeshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bikeshop.adapters.DisplayBasketAdapter
import com.example.bikeshop.database.BicycleApplication
import com.example.bikeshop.databinding.DisplayBasketFragmentBinding
import com.example.bikeshop.models.Bicycle
import com.example.bikeshop.viewmodels.DisplayBasketViewModel

class DisplayBasketFragment : Fragment()
{
    private val viewModel : DisplayBasketViewModel by viewModels{
        DisplayBasketViewModel.DisplayBasketViewModelFactory()
    }
    private var _binding : DisplayBasketFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DisplayBasketFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView()
    {
        setupAdapter()
        setupLayoutManager()
    }

    private fun setupAdapter()
    {
        val adapter = DisplayBasketAdapter(getAllBicyclesFromBasket().value!!)
        _binding!!.displayBasketRecyclerview.adapter = adapter
    }
    private fun getAllBicyclesFromBasket() : MutableLiveData<MutableList<Bicycle>>
    {
        return viewModel.allBicycles
    }
    private fun setupLayoutManager()
    {
        val layoutManager = LinearLayoutManager(context)
        _binding!!.displayBasketRecyclerview.layoutManager = layoutManager
    }

}