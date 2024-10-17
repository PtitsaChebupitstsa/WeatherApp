package com.ptitsa_chebupitsa.weatherapp.domain.repository

import com.ptitsa_chebupitsa.weatherapp.domain.entity.City
import com.ptitsa_chebupitsa.weatherapp.domain.entity.Forecast
import com.ptitsa_chebupitsa.weatherapp.domain.entity.Weather


interface WeatherRepository {

    suspend fun getWeather(cityId: Int): Weather

    suspend fun getForecast(cityId: Int): Forecast

}