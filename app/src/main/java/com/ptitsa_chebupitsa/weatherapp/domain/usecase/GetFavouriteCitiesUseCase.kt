package com.ptitsa_chebupitsa.weatherapp.domain.usecase

import com.ptitsa_chebupitsa.weatherapp.domain.repository.FavouriteRepository
import javax.inject.Inject


class GetFavouriteCitiesUseCase @Inject constructor(private val repository: FavouriteRepository) {

    operator fun invoke() = repository.favoriteCities

}