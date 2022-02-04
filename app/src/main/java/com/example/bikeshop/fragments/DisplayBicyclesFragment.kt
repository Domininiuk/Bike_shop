package com.example.bikeshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bikeshop.adapters.DisplayBicyclesAdapter
import com.example.bikeshop.database.BicycleApplication
import com.example.bikeshop.databinding.DisplayBicyclesFragmentBinding
import com.example.bikeshop.models.Bicycle
import com.example.bikeshop.viewmodels.DisplayBicyclesViewModel
import com.example.bikeshop.viewmodels.DisplayBicyclesViewModelFactory

class DisplayBicyclesFragment : Fragment(), DisplayBicyclesAdapter.AddToCartButtonListener
{

    private val viewModel : DisplayBicyclesViewModel by viewModels{
        DisplayBicyclesViewModelFactory((requireActivity().application as BicycleApplication).bicycleRepository,
            (requireActivity().application as BicycleApplication).basketRepository)
    }
    private var _binding : DisplayBicyclesFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DisplayBicyclesFragmentBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createShoppingCartButtonListener()
        observeAllBicycles()
    }

    private fun createShoppingCartButtonListener()
    {
        _binding!!.shoppingCartButton.setOnClickListener {
            navigateToBasketFragment()
        }
    }
    private fun navigateToBasketFragment()
    {
        val action = DisplayBicyclesFragmentDirections.actionDisplayBicyclesFragmentToDisplayBasketFragment()
        findNavController().navigate(action)
    }
    private fun observeAllBicycles()
    {
        viewModel.allBikes.observe(this.viewLifecycleOwner) {
            setupRecyclerView(it)
        }
    }

    private fun setupRecyclerView(bicycles : List<Bicycle>)
    {
        setupAdapter(bicycles)
        setupLayoutManager()
    }
    private fun setupAdapter(bicycles: List<Bicycle>)
    {
        val adapter = DisplayBicyclesAdapter(bicycles)
        adapter.setAddCartButtonListener(this)
        _binding!!.displayBicyclesRecyclerview.adapter = adapter

    }
    private fun setupLayoutManager()
    {
        val layoutManager = LinearLayoutManager(context)
        _binding!!.displayBicyclesRecyclerview.layoutManager = layoutManager
    }

    override fun onButtonPressed(bicycle: Bicycle) {
        viewModel.addBikeToBasket(bicycle)
    }


}