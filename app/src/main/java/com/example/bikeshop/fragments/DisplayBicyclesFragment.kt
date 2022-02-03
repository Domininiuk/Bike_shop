package com.example.bikeshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bikeshop.adapters.DisplayBicyclesAdapter
import com.example.bikeshop.database.BicycleApplication
import com.example.bikeshop.database.BicycleRoomDatabase
import com.example.bikeshop.databinding.DisplayBicyclesFragmentBinding
import com.example.bikeshop.models.Bicycle
import com.example.bikeshop.viewmodels.DisplayBicyclesViewModel
import com.example.bikeshop.viewmodels.DisplayBicyclesViewModelFactory

class DisplayBicyclesFragment : Fragment()
{

    private val viewModel : DisplayBicyclesViewModel by viewModels{
        DisplayBicyclesViewModelFactory((requireActivity().application as BicycleApplication).repository)
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
        observeAllBicycles()

    }

    private fun observeAllBicycles()
    {
        viewModel.allBikes.observe(this.viewLifecycleOwner) {
            setupRecyclerview(it)
        }
    }

    private fun setupRecyclerview(bicycles : List<Bicycle>)
    {
        setupAdapter(bicycles)
        setupLayoutManager()
    }
    private fun setupAdapter(bicycles: List<Bicycle>)
    {
        val adapter = DisplayBicyclesAdapter(bicycles)
        _binding!!.displayBicyclesRecyclerview.adapter = adapter

    }
    private fun setupLayoutManager()
    {
        val layoutManager = LinearLayoutManager(context)
        _binding!!.displayBicyclesRecyclerview.layoutManager = layoutManager
    }
}