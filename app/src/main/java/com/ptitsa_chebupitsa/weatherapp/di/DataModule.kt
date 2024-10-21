package com.ptitsa_chebupitsa.weatherapp.di

import android.content.Context
import com.ptitsa_chebupitsa.weatherapp.data.loacal.db.FavouriteCitiesDao
import com.ptitsa_chebupitsa.weatherapp.data.loacal.db.FavouriteDatabase
import com.ptitsa_chebupitsa.weatherapp.data.network.api.ApiFactory
import com.ptitsa_chebupitsa.weatherapp.data.network.api.ApiService
import com.ptitsa_chebupitsa.weatherapp.data.repository.FavouriteRepositoryImpl
import com.ptitsa_chebupitsa.weatherapp.data.repository.SearchRepositoryImpl
import com.ptitsa_chebupitsa.weatherapp.data.repository.WeatherRepositoryImpl
import com.ptitsa_chebupitsa.weatherapp.domain.repository.FavouriteRepository
import com.ptitsa_chebupitsa.weatherapp.domain.repository.SearchRepository
import com.ptitsa_chebupitsa.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @[ApplicationScope Binds]
    fun bindFavouriteRepository(impl: FavouriteRepositoryImpl): FavouriteRepository

    @[ApplicationScope Binds]
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @[ApplicationScope Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    companion object {

        @[ApplicationScope Provides]
        fun provideApiService(): ApiService = ApiFactory.apiService

        @[ApplicationScope Provides]
        fun provideFavouriteDatabase(context: Context): FavouriteDatabase {
            return FavouriteDatabase.getInstance(context)
        }

        @[ApplicationScope Provides]
        fun provideFavouriteCitiesDao(database: FavouriteDatabase): FavouriteCitiesDao {
            return database.favouriteCitiesDao()
        }
    }
}
