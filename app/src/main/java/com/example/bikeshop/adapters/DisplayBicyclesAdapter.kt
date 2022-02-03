package com.example.bikeshop.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bikeshop.models.Bicycle

class DisplayBicyclesAdapter(val bicycles : List<Bicycle>) : RecyclerView.Adapter<DisplayBicyclesAdapter.BicycleViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BicycleViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BicycleViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class BicycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}