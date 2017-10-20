package com.luismunyoz.flightsearch.domain.entity

/**
 * Created by Luis on 25/09/2017.
 */
class Segment(
        val id : Int,
        val originStation : Place,
        val destinationStation : Place,
        val departureDateTime : String,
        val arrivalDateTime : String,
        val carrier : Carrier,
        val operatingCarrier : Carrier,
        val duration : Int,
        val flightNumber : String,
        val journeyMode : String,
        val directionality: String
)