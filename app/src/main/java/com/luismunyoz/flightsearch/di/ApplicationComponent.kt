package com.luismunyoz.flightsearch.di

import com.luismunyoz.flightsearch.di.subcomponent.init.InitActivityComponent
import com.luismunyoz.flightsearch.di.subcomponent.init.InitActivityModule
import com.luismunyoz.flightsearch.di.subcomponent.main.MainActivityComponent
import com.luismunyoz.flightsearch.di.subcomponent.main.MainActivityModule
import com.luismunyoz.flightsearch.di.subcomponent.search_places.SearchPlacesActivityComponent
import com.luismunyoz.flightsearch.di.subcomponent.search_places.SearchPlacesActivityModule
import com.luismunyoz.flightsearch.ui.screens.search_places.SearchPlacesActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        DataModule::class,
        RepositoryModule::class,
        DomainModule::class
))
interface ApplicationComponent {

    fun plus(module: MainActivityModule): MainActivityComponent

    fun plus(module: InitActivityModule) : InitActivityComponent

    fun plus(module: SearchPlacesActivityModule) : SearchPlacesActivityComponent
}