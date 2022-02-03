package com.example.bikeshop.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "bicycle_table")
data class Bicycle(@PrimaryKey(autoGenerate = true) val id : Int= 0,
                   val name : String,
                   val price : Int,
                   val colour : String,
                   val brand : String,
                   /*
                   @Ignore
                   var quantity: Int = 1

                    */
)
{

}
