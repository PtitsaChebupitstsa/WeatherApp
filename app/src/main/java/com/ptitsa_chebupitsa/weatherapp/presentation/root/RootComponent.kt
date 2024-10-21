package com.ptitsa_chebupitsa.weatherapp.presentation.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.ptitsa_chebupitsa.weatherapp.presentation.details.DetailsComponent
import com.ptitsa_chebupitsa.weatherapp.presentation.favorite.FavouriteComponent
import com.ptitsa_chebupitsa.weatherapp.presentation.search.SearchComponent

interface RootComponent {

    val stack :Value<ChildStack<*,Child>>

    sealed interface Child{

        data class Favourite(val component:FavouriteComponent):Child

        data class Search(val component:SearchComponent):Child

        data class Details(val component:DetailsComponent):Child

    }

}