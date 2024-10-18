package com.ptitsa_chebupitsa.weatherapp

import android.app.Application
import com.ptitsa_chebupitsa.weatherapp.di.ApplicationComponent
import com.ptitsa_chebupitsa.weatherapp.di.DaggerApplicationComponent

class WeatherApp:Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent =DaggerApplicationComponent.factory().create(this)
    }
}