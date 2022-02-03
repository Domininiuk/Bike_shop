package com.example.bikeshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.bikeshop.database.BicycleRoomDatabase

class DisplayBicyclesFragment : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bikes =  BicycleRoomDatabase.getDatabase(requireContext(), this.lifecycleScope).BicycleDao().getAllBikes()
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bikes =  BicycleRoomDatabase.getDatabase(requireContext(), this.lifecycleScope).BicycleDao().getAllBikes()
    }
}