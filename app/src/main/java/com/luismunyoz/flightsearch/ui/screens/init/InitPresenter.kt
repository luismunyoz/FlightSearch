package com.luismunyoz.flightsearch.ui.screens.init

import com.luismunyoz.flightsearch.domain.interactor.SearchPlacesInteractor
import com.luismunyoz.flightsearch.domain.interactor.base.Bus
import com.luismunyoz.flightsearch.domain.interactor.base.InteractorExecutor
import com.luismunyoz.flightsearch.domain.interactor.event.SearchPlacesEvent
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace
import com.luismunyoz.flightsearch.ui.entity.mapper.UISearchPlaceMapper

/**
 * Created by llco on 23/10/2017.
 */
class InitPresenter(val view: InitContract.View,
                    override val bus: Bus,
                    val searchPlacesInteractor: SearchPlacesInteractor,
                    val interactorExecutor: InteractorExecutor,
                    val uiSearchPlaceMapper: UISearchPlaceMapper) : InitContract.Presenter {

    override fun onSearchPressed(query: String) {
        searchPlacesInteractor.query = query

        interactorExecutor.execute(searchPlacesInteractor)
    }

    fun onEvent(event: SearchPlacesEvent) {
        view.populateSearchResults(uiSearchPlaceMapper.transform(event.places))
    }

}