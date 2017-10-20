package com.luismunyoz.flightsearch.di.subcomponent.main


import com.luismunyoz.flightsearch.di.scope.ActivityScope
import com.luismunyoz.flightsearch.ui.screens.main.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(
        MainActivityModule::class
))
interface MainActivityComponent {

    fun injectTo(activity: MainActivity)
}