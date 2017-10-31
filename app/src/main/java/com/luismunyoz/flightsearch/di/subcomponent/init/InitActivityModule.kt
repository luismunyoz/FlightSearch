package com.luismunyoz.flightsearch.di.subcomponent.init

import com.luismunyoz.flightsearch.di.ActivityModule
import com.luismunyoz.flightsearch.di.scope.ActivityScope
import com.luismunyoz.flightsearch.domain.interactor.GetFlightPricesInteractor
import com.luismunyoz.flightsearch.domain.interactor.SearchPlacesInteractor
import com.luismunyoz.flightsearch.domain.interactor.base.Bus
import com.luismunyoz.flightsearch.domain.interactor.base.InteractorExecutor
import com.luismunyoz.flightsearch.ui.entity.mapper.UIFlightPricesMapper
import com.luismunyoz.flightsearch.ui.entity.mapper.UISearchPlaceMapper
import com.luismunyoz.flightsearch.ui.screens.init.InitActivity
import com.luismunyoz.flightsearch.ui.screens.init.InitContract
import com.luismunyoz.flightsearch.ui.screens.init.InitPresenter
import com.luismunyoz.flightsearch.ui.screens.main.MainActivity
import com.luismunyoz.flightsearch.ui.screens.main.MainContract
import com.luismunyoz.flightsearch.ui.screens.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class InitActivityModule(activity: InitActivity) : ActivityModule(activity) {

    @Provides
    @ActivityScope
    fun provideInitView(): InitContract.View = activity as InitContract.View

    @Provides
    @ActivityScope
    fun provideUISearchPlaceMapper() = UISearchPlaceMapper()

    @Provides
    @ActivityScope
    fun provideInitPresenter(view: InitContract.View, bus: Bus, uiSearchPlaceMapper: UISearchPlaceMapper) =
            InitPresenter(view, bus, uiSearchPlaceMapper)

}