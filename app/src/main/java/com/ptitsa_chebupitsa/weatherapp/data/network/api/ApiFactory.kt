package com.ptitsa_chebupitsa.weatherapp.data.network.api

import com.arkivanov.mvikotlin.core.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.Locale

object ApiFactory {

    private const val BASE_URL = "https://api.weatherapi.com/v1/"
    private const val API_KEY_PARAM = "a8d78631ff7c4b39be574055241710"
    private const val PARAM_LANG = "lang"
    private const val KEY_PARAM = "key"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val newUrl = originalRequest
                .url()
                .newBuilder()
                .addQueryParameter("key", "")
                .build()
            val newRequest = originalRequest.newBuilder()
                .url(newUrl)
                .build()
            chain.proceed(newRequest)
        }.build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val apiService: ApiService = retrofit.create()

}