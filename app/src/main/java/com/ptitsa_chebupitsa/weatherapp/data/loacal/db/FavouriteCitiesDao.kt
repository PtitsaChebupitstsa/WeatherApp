package com.ptitsa_chebupitsa.weatherapp.data.loacal.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ptitsa_chebupitsa.weatherapp.data.loacal.model.CityDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteCitiesDao {

    @Query("SELECT * FROM favourite_cities")
    fun getFavouriteCities(): Flow<List<CityDbModel>>

    @Query("SELECT EXISTS(SELECT * FROM favourite_cities WHERE id = :cityId LIMIT 1)")
    fun observeIsFavourite(cityId: Int): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavourite(city: CityDbModel)

    @Query("DELETE FROM favourite_cities WHERE id = :cityId")
    suspend fun removeFromFavourite(cityId: Int)


}