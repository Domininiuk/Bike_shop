package com.example.bikeshop.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "basket_table")
data class BasketItem(@PrimaryKey val id : Int,  var quantity : Int = 0)
{

}