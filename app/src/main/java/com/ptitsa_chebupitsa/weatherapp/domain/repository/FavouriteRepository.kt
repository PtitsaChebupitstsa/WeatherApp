package com.ptitsa_chebupitsa.weatherapp.domain.repository

import com.ptitsa_chebupitsa.weatherapp.domain.entity.City
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {

    val favoriteCities: Flow<City>

    fun observeIsFavorite(cityId: Int): Flow<Boolean>

    suspend fun addToFavorite(city: City)

    suspend fun removeToFavorite(cityId: Int)

}