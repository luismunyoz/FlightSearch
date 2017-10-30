package com.luismunyoz.flightsearch.di.subcomponent.search_places

import com.luismunyoz.flightsearch.di.ActivityModule
import com.luismunyoz.flightsearch.di.scope.ActivityScope
import com.luismunyoz.flightsearch.domain.interactor.SearchPlacesInteractor
import com.luismunyoz.flightsearch.domain.interactor.base.Bus
import com.luismunyoz.flightsearch.domain.interactor.base.InteractorExecutor
import com.luismunyoz.flightsearch.ui.entity.mapper.UISearchPlaceMapper
import com.luismunyoz.flightsearch.ui.screens.search_places.SearchPlacesActivity
import com.luismunyoz.flightsearch.ui.screens.search_places.SearchPlacesContract
import com.luismunyoz.flightsearch.ui.screens.search_places.SearchPlacesPresenter
import dagger.Module
import dagger.Provides

@Module
class SearchPlacesActivityModule(activity: SearchPlacesActivity) : ActivityModule(activity) {

    @Provides
    @ActivityScope
    fun provideSearchPlacesView(): SearchPlacesContract.View = activity as SearchPlacesContract.View

    @Provides
    @ActivityScope
    fun provideUISearchPlaceMapper() = UISearchPlaceMapper()

    @Provides
    @ActivityScope
    fun provideSearchPlacesPresenter(view: SearchPlacesContract.View, bus: Bus, searchPlacesInteractor: SearchPlacesInteractor, interactorExecutor: InteractorExecutor, uiSearchPlaceMapper: UISearchPlaceMapper) =
            SearchPlacesPresenter(view, bus, searchPlacesInteractor, interactorExecutor, uiSearchPlaceMapper)

}