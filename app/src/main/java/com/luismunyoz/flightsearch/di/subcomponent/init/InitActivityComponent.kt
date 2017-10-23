package com.luismunyoz.flightsearch.di.subcomponent.init

import com.luismunyoz.flightsearch.di.scope.ActivityScope
import com.luismunyoz.flightsearch.di.subcomponent.main.MainActivityModule
import com.luismunyoz.flightsearch.ui.screens.init.InitActivity
import com.luismunyoz.flightsearch.ui.screens.main.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(
        InitActivityModule::class
))
interface InitActivityComponent {

    fun injectTo(activity: InitActivity)
}