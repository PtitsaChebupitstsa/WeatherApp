package com.ptitsa_chebupitsa.weatherapp.presentation.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.ptitsa_chebupitsa.weatherapp.presentation.details.DetailsComponent
import com.ptitsa_chebupitsa.weatherapp.presentation.details.DetailsContent
import com.ptitsa_chebupitsa.weatherapp.presentation.favorite.FavouriteContent
import com.ptitsa_chebupitsa.weatherapp.presentation.search.SearchContent
import com.ptitsa_chebupitsa.weatherapp.presentation.theme.WeatherAppTheme

@Composable
fun RootContent(component: RootComponent) {

    WeatherAppTheme {
        Children(stack = component.stack) {

            when (val instance = it.instance) {
                is RootComponent.Child.Details -> {
                    DetailsContent(component = instance.component)
                }

                is RootComponent.Child.Favourite -> {
                    FavouriteContent(component = instance.component)
                }

                is RootComponent.Child.Search -> {
                    SearchContent(component = instance.component)
                }
            }

        }
    }


}