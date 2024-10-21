package com.ptitsa_chebupitsa.weatherapp.presentation.search

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.ptitsa_chebupitsa.weatherapp.domain.entity.City
import com.ptitsa_chebupitsa.weatherapp.presentation.extensions.componentScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DefaultSearchComponent(
    private val openReason: OpenReason,
    private val searchStoreFactory: SearchStoreFactory,
    private val onClickedBack: () -> Unit,
    private val onCitySavedToFavourite: () -> Unit,
    private val onForecastForCityRequested: (City) -> Unit,
    componentContext: ComponentContext
) : SearchComponent, ComponentContext by componentContext {

    private val store = searchStoreFactory.create(openReason)
    private val scope = componentScope()

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<SearchStore.State>
        get() = store.stateFlow

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    SearchStore.Label.ClickBack -> {
                        onClickedBack()
                    }

                    is SearchStore.Label.OpenForecast -> {
                        onForecastForCityRequested(it.city)
                    }

                    SearchStore.Label.SavedToFavourite -> {
                        onCitySavedToFavourite()
                    }
                }
            }
        }
    }

    override fun changeSearchQuery(query: String) {
        store.accept(SearchStore.Intent.ChangeSearchQuery(query))
    }

    override fun onClickBack() {
        store.accept(SearchStore.Intent.ClickBack)
    }

    override fun onClickSearch() {
        store.accept(SearchStore.Intent.ClickSearch)
    }

    override fun onClickCity(city: City) {
        store.accept(SearchStore.Intent.ClickCity(city))
    }
}