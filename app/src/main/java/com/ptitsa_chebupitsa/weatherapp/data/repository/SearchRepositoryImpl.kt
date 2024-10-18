package com.ptitsa_chebupitsa.weatherapp.data.repository

import com.ptitsa_chebupitsa.weatherapp.data.mapper.toEntities
import com.ptitsa_chebupitsa.weatherapp.data.network.api.ApiService
import com.ptitsa_chebupitsa.weatherapp.domain.entity.City
import com.ptitsa_chebupitsa.weatherapp.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SearchRepository {

    override suspend fun search(query: String): List<City> =
        apiService.searchCity(query).toEntities()
}