package com.luismunyoz.flightsearch.domain.entity

/**
 * Created by Luis on 25/09/2017.
 */
class FlightPrices (
        val sessionKey : String,
        val query : Query,
        val status : String,
        val itineraries : List<Itinerary>,
        val currencies : List<Currency>
)