package com.luismunyoz.flightsearch.ui.screens.search_places

import com.luismunyoz.flightsearch.domain.entity.SearchPlace
import com.luismunyoz.flightsearch.domain.interactor.SearchPlacesInteractor
import com.luismunyoz.flightsearch.domain.interactor.base.Bus
import com.luismunyoz.flightsearch.domain.interactor.base.InteractorExecutor
import com.luismunyoz.flightsearch.domain.interactor.event.SearchPlacesEvent
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace
import com.luismunyoz.flightsearch.ui.entity.mapper.UISearchPlaceMapper
import com.luismunyoz.flightsearch.ui.screens.init.InitContract

/**
 * Created by llco on 23/10/2017.
 */
class SearchPlacesPresenter(val view: SearchPlacesContract.View,
                            override val bus: Bus,
                            val searchPlacesInteractor: SearchPlacesInteractor,
                            val interactorExecutor: InteractorExecutor,
                            val uiSearchPlaceMapper: UISearchPlaceMapper) : SearchPlacesContract.Presenter {

    val places : ArrayList<SearchPlace> = ArrayList()

    override fun onSearchPressed(query: String) {
        searchPlacesInteractor.query = query

        interactorExecutor.execute(searchPlacesInteractor)
    }

    fun onEvent(event: SearchPlacesEvent) {
        places.clear()
        places.addAll(event.places)
        view.populateSearchResults(uiSearchPlaceMapper.transform(places))
    }

    override fun onPlaceSelected(place: UISearchPlace) {
        view.returnPlace(places.first { it.placeId == place.placeId })
    }

}