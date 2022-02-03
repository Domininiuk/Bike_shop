package com.example.bikeshop.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bicycle_table")
data class Bicycle(@PrimaryKey(autoGenerate = true) val id : Int= 0,
                   val name : String,
                   val price : String,
                   val colour : String,
                   val brand : String
)
{

}
