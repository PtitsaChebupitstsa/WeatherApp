package com.ptitsa_chebupitsa.weatherapp.di

import android.content.Context
import com.ptitsa_chebupitsa.weatherapp.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [DataModule::class,
    PresentationModule::class]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory{

        fun create (
            @BindsInstance context: Context
        ):ApplicationComponent
    }
}