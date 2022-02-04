package com.example.bikeshop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView
import com.example.bikeshop.R
import com.example.bikeshop.databinding.DisplayBasketRecyclerviewItemBinding
import com.example.bikeshop.databinding.DisplayBicyclesRecyclerviewItemBinding
import com.example.bikeshop.models.Bicycle

class DisplayBasketAdapter(private val bicycles : List<Bicycle>) : RecyclerView.Adapter<DisplayBasketAdapter.BasketItemViewHolder>() {

    lateinit var removeFromCartButtonListener : RemoveFromCartButtonListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.display_basket_recyclerview_item,
        parent, false)
        return BasketItemViewHolder(view, removeFromCartButtonListener)
    }

    override fun onBindViewHolder(holder: BasketItemViewHolder, position: Int) {
        holder.bind(bicycles[position])
    }

    override fun getItemCount(): Int {
        return bicycles.count()
    }
    class BasketItemViewHolder(itemView: View, val removeFromCartButtonListener: RemoveFromCartButtonListener) : RecyclerView.ViewHolder(itemView) {
        private var _binding = DisplayBasketRecyclerviewItemBinding.bind(itemView)
        private lateinit var bicycle : Bicycle
        fun bind(bicycle: Bicycle)
        {
            this.bicycle = bicycle
            setName(bicycle.name)
            setBrand(bicycle.brand)
            setColour(bicycle.colour)
            setPrice(bicycle.price)
            setRemoveFromCartButtonListener()
        }


        private fun setName(name : String)
        {
            _binding.name.text = name
        }
        private fun setBrand(brand : String)
        {
            _binding.brand.text = brand
        }
        private fun setColour(colour : String)
        {
            _binding.colour.text = colour
        }
        private fun setPrice(price : Int)
        {
            _binding.price.text = price.toString() + " zł"
        }
        fun setRemoveFromCartButtonListener()
        {
            _binding.removeFromCartButton.setOnClickListener{
                removeFromCartButtonListener.onButtonPressed(adapterPosition)
                disableTheButton()
            }
        }
        fun disableTheButton()
        {
            _binding.removeFromCartButton.isClickable = false
        }
    }

    interface RemoveFromCartButtonListener
    {
       fun onButtonPressed(index : Int)
    }
    fun setAddCartButtonListener(listener : RemoveFromCartButtonListener)
    {
        removeFromCartButtonListener = listener
    }
}