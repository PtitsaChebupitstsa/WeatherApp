package com.ptitsa_chebupitsa.weatherapp.data.repository

import com.ptitsa_chebupitsa.weatherapp.data.mapper.toEntity
import com.ptitsa_chebupitsa.weatherapp.data.network.api.ApiService
import com.ptitsa_chebupitsa.weatherapp.domain.entity.Forecast
import com.ptitsa_chebupitsa.weatherapp.domain.entity.Weather
import com.ptitsa_chebupitsa.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WeatherRepository {

    override suspend fun getWeather(cityId: Int): Weather = apiService.loadCurrentWeather("$PREFIX_CITY_ID$cityId").toEntity()

    override suspend fun getForecast(cityId: Int): Forecast {
        return apiService.loadForecast("$PREFIX_CITY_ID$cityId").toEntity()
    }
    private companion object{
        private const val PREFIX_CITY_ID = "id:"
    }
}