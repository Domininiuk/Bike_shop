package com.example.bikeshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bikeshop.adapters.DisplayBasketAdapter
import com.example.bikeshop.database.BicycleApplication
import com.example.bikeshop.databinding.DisplayBasketFragmentBinding
import com.example.bikeshop.models.Bicycle
import com.example.bikeshop.singletons.Basket
import com.example.bikeshop.viewmodels.DisplayBasketViewModel

class DisplayBasketFragment : Fragment(), DisplayBasketAdapter.RemoveFromCartButtonListener {
    private val viewModel: DisplayBasketViewModel by viewModels {
        DisplayBasketViewModel.DisplayBasketViewModelFactory((requireActivity().application as BicycleApplication).bicycleRepository)
    }
    private var _binding: DisplayBasketFragmentBinding? = null
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

       observeAllBasketItems()
       updateTotalPrice()

    }

    private fun observeAllBasketItems()
    {
        viewModel.allBasketItems.observe(this.viewLifecycleOwner){
            setupRecyclerView(it)
            updateTotalPrice()
        }
    }
    private fun setupRecyclerView(bicycles : List<Bicycle>) {
        setupAdapter(bicycles)
        setupLayoutManager()
    }

    private fun setupAdapter(bicycles : List<Bicycle>) {
        val adapter = DisplayBasketAdapter(bicycles)
        adapter.setAddCartButtonListener(this)
        _binding!!.displayBasketRecyclerview.adapter = adapter
    }


    private fun setupLayoutManager() {
        val layoutManager = LinearLayoutManager(context)
        _binding!!.displayBasketRecyclerview.layoutManager = layoutManager
    }
    private fun updateTotalPrice()
    {
        _binding!!.totalPrice.text = getTotalPrice().toString()
    }
    fun getTotalPrice() : Int
    {
        return viewModel.getTotalPrice()
    }
    override fun onButtonPressed(index: Int) {
        viewModel.removeBicycleFromBasket(index)
       updateTheBasket(index)
    }
    fun updateTheBasket(index : Int)
    {
        _binding!!.displayBasketRecyclerview.adapter?.notifyItemRemoved(index)
        updateTotalPrice()
    }
}