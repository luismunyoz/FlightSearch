package com.luismunyoz.flightsearch

import android.app.Application
import com.luismunyoz.flightsearch.di.ApplicationComponent
import com.luismunyoz.flightsearch.di.ApplicationModule
import com.luismunyoz.flightsearch.di.DaggerApplicationComponent


class App : Application() {

    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    fun initializeDagger() {
        graph = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}