package com.ptitsa_chebupitsa.weatherapp.presentation.search

import androidx.room.Query
import com.ptitsa_chebupitsa.weatherapp.domain.entity.City
import kotlinx.coroutines.flow.StateFlow

interface SearchComponent {

    val model:StateFlow<SearchStore.State>

    fun changeSearchQuery(query: String)

    fun onClickBack()

    fun onClickSearch()

    fun onClickCity(city:City)

}