package com.ptitsa_chebupitsa.weatherapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class WeatherForecastDto(
    @SerializedName("forecast") val forecast: ForecastDto,
    @SerializedName("current") val current: WeatherDto

)