package com.luismunyoz.flightsearch.di.subcomponent.search_places

import com.luismunyoz.flightsearch.di.scope.ActivityScope
import com.luismunyoz.flightsearch.di.subcomponent.main.MainActivityModule
import com.luismunyoz.flightsearch.di.subcomponent.search_places.SearchPlacesActivityModule
import com.luismunyoz.flightsearch.ui.screens.init.InitActivity
import com.luismunyoz.flightsearch.ui.screens.main.MainActivity
import com.luismunyoz.flightsearch.ui.screens.search_places.SearchPlacesActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(
        SearchPlacesActivityModule::class
))
interface SearchPlacesActivityComponent {

    fun injectTo(activity: SearchPlacesActivity)
}