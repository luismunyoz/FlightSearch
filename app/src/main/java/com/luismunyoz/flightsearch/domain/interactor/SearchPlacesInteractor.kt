package com.luismunyoz.flightsearch.domain.interactor

import com.luismunyoz.flightsearch.domain.interactor.base.Event
import com.luismunyoz.flightsearch.domain.interactor.base.Interactor
import com.luismunyoz.flightsearch.domain.interactor.event.FlightPricesEvent
import com.luismunyoz.flightsearch.domain.interactor.event.SearchPlacesEvent
import com.luismunyoz.flightsearch.domain.repository.FlightSearchRepository

/**
 * Created by Luism on 27/09/2017.
 */
class SearchPlacesInteractor(val flightSearchRepository: FlightSearchRepository) : Interactor {

    var country : String = "UK"
    var currency : String = "GBP"
    var locale : String = "en-GB"
    var query : String? = null

    override fun invoke(): Event {
        val query = this.query ?: throw IllegalStateException("Query can't be null")

        val places = flightSearchRepository.searchPlaces(country, currency, locale, query)
        return SearchPlacesEvent(places)
    }

}