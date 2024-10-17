package com.ptitsa_chebupitsa.weatherapp.domain.usecase

import com.ptitsa_chebupitsa.weatherapp.domain.repository.SearchRepository
import javax.inject.Inject

class SearchCityUseCase@Inject constructor(private val repository: SearchRepository)  {

suspend operator fun invoke(query: String) = repository.search(query)

}