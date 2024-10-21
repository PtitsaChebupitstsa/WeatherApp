package com.ptitsa_chebupitsa.weatherapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.app.AppComponentFactory
import com.arkivanov.decompose.defaultComponentContext
import com.ptitsa_chebupitsa.weatherapp.WeatherApp
import com.ptitsa_chebupitsa.weatherapp.data.network.api.ApiFactory
import com.ptitsa_chebupitsa.weatherapp.domain.usecase.ChangeFavouriteStateUseCase
import com.ptitsa_chebupitsa.weatherapp.domain.usecase.SearchCityUseCase
import com.ptitsa_chebupitsa.weatherapp.presentation.root.DefaultRootComponent
import com.ptitsa_chebupitsa.weatherapp.presentation.root.RootContent
import com.ptitsa_chebupitsa.weatherapp.presentation.theme.WeatherAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var rootComponentFactory: DefaultRootComponent.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        //иньекция в поля
        (applicationContext as WeatherApp).applicationComponent.inject(this)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RootContent(component = rootComponentFactory.create(defaultComponentContext()))
        }
    }
}

