package com.example.bikeshop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bikeshop.R
import com.example.bikeshop.models.Bicycle

class DisplayBicyclesAdapter(val bicycles : List<Bicycle>) : RecyclerView.Adapter<DisplayBicyclesAdapter.BicycleViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BicycleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.display_bicycles_recyclerview_item,
            parent,false)
        return BicycleViewHolder(view)
    }

    override fun onBindViewHolder(holder: BicycleViewHolder, position: Int) {
        holder.bind(bicycles[position])
    }

    override fun getItemCount(): Int {
        return bicycles.count()
    }

    class BicycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(bicycle : Bicycle)
        {
            setName(bicycle.name)
            setBrand(bicycle.brand)
            setColour(bicycle.colour)
            setPrice(bicycle.price)
        }

        private fun setName(name : String)
        {
            itemView.findViewById<TextView>(R.id.name).setText(name)
        }
        private fun setBrand(brand : String)
        {
            itemView.findViewById<TextView>(R.id.brand).setText(brand)
        }
        fun setColour(colour : String)
        {
            itemView.findViewById<TextView>(R.id.colour).setText(colour)
        }
        private fun setPrice(price : Int)
        {
            itemView.findViewById<TextView>(R.id.price).setText(price.toString())
        }

    }
}