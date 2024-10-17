package com.ptitsa_chebupitsa.weatherapp.data.loacal.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_cities")
data class CityDbModel(
    @PrimaryKey
    val id: Int,
    val name: String,
    val country: String
)
