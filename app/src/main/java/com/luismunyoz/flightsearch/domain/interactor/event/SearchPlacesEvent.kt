package com.luismunyoz.flightsearch.domain.interactor.event

import com.luismunyoz.flightsearch.domain.entity.SearchPlace
import com.luismunyoz.flightsearch.domain.interactor.base.Event

/**
 * Created by llco on 23/10/2017.
 */
data class SearchPlacesEvent(val places : List<SearchPlace>) : Event