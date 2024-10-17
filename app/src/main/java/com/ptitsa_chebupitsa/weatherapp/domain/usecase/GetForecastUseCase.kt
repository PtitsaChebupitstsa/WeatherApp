package com.ptitsa_chebupitsa.weatherapp.domain.usecase

import com.ptitsa_chebupitsa.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(private val repository: WeatherRepository) {

    suspend operator fun invoke(cityId: Int) = repository.getForecast(cityId)

}