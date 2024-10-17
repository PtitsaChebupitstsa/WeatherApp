package com.ptitsa_chebupitsa.weatherapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ptitsa_chebupitsa.weatherapp.data.network.api.ApiFactory
import com.ptitsa_chebupitsa.weatherapp.presentation.theme.WeatherAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val apiService = ApiFactory.apiService

        CoroutineScope(Dispatchers.IO).launch {
            val currentWatcher = apiService.loadCurrentWeather("Moscow")
            val forecast = apiService.loadForecast("Moscow")
            val cities = apiService.searchCity("Moscow")
            Log.d("MainActivity","currentWatcher = $currentWatcher")
            Log.d("MainActivity","currentWatcher = $forecast")
            Log.d("MainActivity","currentWatcher = $cities")

        }
        setContent {
            WeatherAppTheme {

            }
        }
    }
}

