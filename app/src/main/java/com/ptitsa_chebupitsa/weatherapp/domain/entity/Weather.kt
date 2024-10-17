package com.ptitsa_chebupitsa.weatherapp.domain.entity

import java.util.Calendar

data class Weather(
    val tempC:Float,
    val conditionText:String,
    val conditionUrl:String,
    val data:Calendar
)
