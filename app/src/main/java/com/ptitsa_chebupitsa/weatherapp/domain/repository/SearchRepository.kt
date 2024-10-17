package com.ptitsa_chebupitsa.weatherapp.domain.repository

import com.ptitsa_chebupitsa.weatherapp.domain.entity.City

interface SearchRepository {

    suspend fun search(query: String): List<City>

}