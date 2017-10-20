package com.luismunyoz.flightsearch.di

import com.luismunyoz.flightsearch.di.subcomponent.main.MainActivityComponent
import com.luismunyoz.flightsearch.di.subcomponent.main.MainActivityModule
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
}