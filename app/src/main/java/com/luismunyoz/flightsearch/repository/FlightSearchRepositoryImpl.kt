package com.luismunyoz.flightsearch.repository

import com.luismunyoz.flightsearch.domain.entity.FlightPrices
import com.luismunyoz.flightsearch.domain.entity.SearchPlace
import com.luismunyoz.flightsearch.domain.repository.FlightSearchRepository
import com.luismunyoz.flightsearch.repository.dataset.FlightPricesDataSet

/**
 * Created by Luis on 25/09/2017.
 */
class FlightSearchRepositoryImpl(val flightPricesDataSets: List<FlightPricesDataSet>) : FlightSearchRepository {

    override fun getFlightPrices(cabinClass: String, country: String, currency: String, locale: String, locationSchema: String, originPlace: String, destinationPlace: String, outboundDate: String, inboundDate: String, adults: Int, children: Int, infants: Int, pageIndex: Int, pageSize : Int) : FlightPrices? {
        return flightPricesDataSets.map { it.requestFlightPrices(cabinClass, country, currency, locale, locationSchema, originPlace, destinationPlace, outboundDate, inboundDate, adults, children, infants, pageIndex, pageSize) }
                .firstOrNull()
    }

    override fun searchPlaces(country: String, currency: String, locale: String, query: String): List<SearchPlace> {
        return flightPricesDataSets.map { it.searchPlaces(country, currency, locale, query) }.first()
    }

}