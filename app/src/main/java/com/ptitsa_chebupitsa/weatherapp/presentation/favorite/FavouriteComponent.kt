package com.ptitsa_chebupitsa.weatherapp.presentation.favorite

import com.ptitsa_chebupitsa.weatherapp.domain.entity.City
import kotlinx.coroutines.flow.StateFlow

interface FavouriteComponent {

    val model :StateFlow<FavouriteStore.State>

    fun onClickSearch()

    fun  onClickAddFavourite()

    fun onCityItemClick(city: City)

}