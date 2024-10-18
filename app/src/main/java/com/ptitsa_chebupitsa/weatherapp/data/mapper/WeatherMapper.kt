package com.ptitsa_chebupitsa.weatherapp.data.mapper


import com.ptitsa_chebupitsa.weatherapp.data.network.dto.WeatherCurrentDto
import com.ptitsa_chebupitsa.weatherapp.data.network.dto.WeatherDto
import com.ptitsa_chebupitsa.weatherapp.data.network.dto.WeatherForecastDto
import com.ptitsa_chebupitsa.weatherapp.domain.entity.Forecast
import com.ptitsa_chebupitsa.weatherapp.domain.entity.Weather
import java.util.Calendar
import java.util.Date

fun WeatherCurrentDto.toEntity(): Weather = current.toEntity()

fun WeatherDto.toEntity(): Weather = Weather(
    tempC = tempC,
    conditionText = conditionDto.text,
    conditionUrl = conditionDto.iconUrl.correctImageUrl(),
    date = date.toCalendar()
)

fun WeatherForecastDto.toEntity() = Forecast(
    currentWeather = current.toEntity(),
    upcoming = forecastDto.forecastDay.drop(FORECAST_ID_FOR_TODAY).map { dayDto ->
        val dayWeatherDto = dayDto.dayWeatherDto
        Weather(
            tempC = dayWeatherDto.tempC,
            conditionText = dayWeatherDto.conditionDto.text,
            conditionUrl = dayWeatherDto.conditionDto.iconUrl.correctImageUrl(),
            date = dayDto.date.toCalendar()
        )
    }
)

private fun Long.toCalendar() = Calendar.getInstance().apply {
    time = Date(this@toCalendar * SECONDS_TO_MILLISECONDS)
}

private fun String.correctImageUrl() = "https:$this".replace(
    oldValue = "64x64",
    newValue = "128x128"
)

private const val SECONDS_TO_MILLISECONDS = 1000

private const val FORECAST_ID_FOR_TODAY = 1