package com.ptitsa_chebupitsa.weatherapp.data.mapper

import com.ptitsa_chebupitsa.weatherapp.data.loacal.model.CityDbModel
import com.ptitsa_chebupitsa.weatherapp.domain.entity.City

fun City.toDbModel(): CityDbModel = CityDbModel(id, name, country)

fun CityDbModel.toEntity(): City = City(id, name, country)

fun List<CityDbModel>.toEntities(): List<City> = map { it.toEntity() }