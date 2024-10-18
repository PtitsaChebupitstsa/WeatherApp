package com.ptitsa_chebupitsa.weatherapp.domain.usecase

import com.ptitsa_chebupitsa.weatherapp.domain.entity.City
import com.ptitsa_chebupitsa.weatherapp.domain.repository.FavouriteRepository
import javax.inject.Inject


class ChangeFavouriteStateUseCase @Inject constructor(private val repository: FavouriteRepository) {

    suspend fun addToFavourite(city: City) = repository.addToFavorite(city)

    suspend fun removeFromFavourite(cityId: Int) = repository.removeToFavorite(cityId)

}

