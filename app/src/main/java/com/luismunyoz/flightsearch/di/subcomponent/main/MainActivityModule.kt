package com.luismunyoz.flightsearch.di.subcomponent.main

import com.luismunyoz.flightsearch.di.ActivityModule
import com.luismunyoz.flightsearch.di.scope.ActivityScope
import com.luismunyoz.flightsearch.domain.interactor.GetFlightPricesInteractor
import com.luismunyoz.flightsearch.domain.interactor.base.Bus
import com.luismunyoz.flightsearch.domain.interactor.base.InteractorExecutor
import com.luismunyoz.flightsearch.ui.entity.mapper.UIFlightPricesMapper
import com.luismunyoz.flightsearch.ui.screens.main.MainActivity
import com.luismunyoz.flightsearch.ui.screens.main.MainContract
import com.luismunyoz.flightsearch.ui.screens.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(activity: MainActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideMainView(): MainContract.View = activity as MainContract.View

    @Provides @ActivityScope
    fun provideUIFlightPricesMapper() = UIFlightPricesMapper()

    @Provides @ActivityScope
    fun provideMainPresenter(view: MainContract.View, bus: Bus, getFlightPricesInteractor: GetFlightPricesInteractor, interactorExecutor: InteractorExecutor, uiFlightPricesMapper: UIFlightPricesMapper) =
            MainPresenter(view, bus, getFlightPricesInteractor, interactorExecutor, uiFlightPricesMapper)

}