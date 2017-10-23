package com.luismunyoz.flightsearch.repository.dataset

import com.luismunyoz.flightsearch.domain.entity.FlightPrices
import com.luismunyoz.flightsearch.domain.entity.SearchPlace

/**
 * Created by llco on 25/09/2017.
 */
interface FlightPricesDataSet {

    fun requestFlightPrices(
            cabinClass : String,
            country : String,
            currency: String,
            locale: String,
            locationSchema : String,
            originPlace : String,
            destinationPlace : String,
            outboundDate : String,
            inboundDate : String,
            adults : Int,
            children : Int,
            infants : Int,
            pageIndex : Int,
            pageSize : Int) : FlightPrices

    fun searchPlaces(
            country: String,
            currency: String,
            locale: String,
            query: String
    ) : List<SearchPlace>
}