package com.ptitsa_chebupitsa.weatherapp.data.mapper

import com.ptitsa_chebupitsa.weatherapp.data.network.dto.CityDto
import com.ptitsa_chebupitsa.weatherapp.domain.entity.City

fun CityDto.toEntity(): City = City(id, name, country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }