package com.ptitsa_chebupitsa.weatherapp.data.loacal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ptitsa_chebupitsa.weatherapp.data.loacal.model.CityDbModel

@Database(entities = [CityDbModel::class], version = 1, exportSchema = false)
abstract class FavouriteDatabase : RoomDatabase() {

    abstract fun favouriteCitiesDao(): FavouriteCitiesDao

    companion object {

        private const val DB_NAME = "favourite_cities.db"
        private var INSTANCE: FavouriteDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): FavouriteDatabase {

            INSTANCE?.let { return it }

            synchronized(LOCK) {
                INSTANCE?.let { return it }

                val database = Room.databaseBuilder(
                    context = context,
                    klass = FavouriteDatabase::class.java,
                    name = DB_NAME
                ).build()

                INSTANCE = database
                return database
            }
        }
    }
}