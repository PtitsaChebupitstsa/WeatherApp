package com.ptitsa_chebupitsa.weatherapp.domain.usecase

import com.ptitsa_chebupitsa.weatherapp.domain.entity.City
import com.ptitsa_chebupitsa.weatherapp.domain.repository.FavouriteRepository
import javax.inject.Inject


class ChangeFavouritesStateUseCase @Inject constructor(private val repository: FavouriteRepository) {

    suspend fun addToFavourites(city: City) = repository.addToFavorite(city)

    suspend fun removeFromFavourites(cityId: Int) = repository.removeToFavorite(cityId)

}