package com.luismunyoz.flightsearch.domain.entity

/**
 * Created by Luis on 25/09/2017.
 */
class Leg(
        val id : String,
        val segments : List<Segment>,
        val originStation : Place,
        val destinationStation : Place,
        val departure : String,
        val arrival : String,
        val duration : Int,
        val journeyMode : String,
        val stops : List<Place>,
        val carriers : List<Carrier>,
        val operatingCarriers : List<Carrier>,
        val directionality : String,
        val flightNumbers : List<FlightNumber>
)