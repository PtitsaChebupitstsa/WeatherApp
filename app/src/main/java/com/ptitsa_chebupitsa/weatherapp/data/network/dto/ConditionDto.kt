package com.ptitsa_chebupitsa.weatherapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class ConditionDto(
    @SerializedName("text")val text:String,
    @SerializedName("icon") val iconUrl:String,

)