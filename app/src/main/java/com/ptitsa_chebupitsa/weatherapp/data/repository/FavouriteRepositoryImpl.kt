package com.ptitsa_chebupitsa.weatherapp.data.repository

import com.ptitsa_chebupitsa.weatherapp.data.loacal.db.FavouriteCitiesDao
import com.ptitsa_chebupitsa.weatherapp.data.mapper.toDbModel
import com.ptitsa_chebupitsa.weatherapp.data.mapper.toEntities
import com.ptitsa_chebupitsa.weatherapp.domain.entity.City
import com.ptitsa_chebupitsa.weatherapp.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
    private val favouriteCitiesDao: FavouriteCitiesDao
) : FavouriteRepository {

    override val favoriteCities: Flow<List<City>>
        get() = favouriteCitiesDao.getFavouriteCities()
            .map { it.toEntities() }

    override fun observeIsFavorite(cityId: Int): Flow<Boolean> =
        favouriteCitiesDao.observeIsFavourite(cityId)

    override suspend fun addToFavorite(city: City) =
        favouriteCitiesDao.addToFavourite(city.toDbModel())

    override suspend fun removeToFavorite(cityId: Int) =
        favouriteCitiesDao.removeFromFavourite(cityId)

}