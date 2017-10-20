package com.luismunyoz.flightsearch.data.skyscanner.model

import com.google.gson.annotations.SerializedName

/**
 * Created by llco on 25/09/2017.
 */
class SkySegment(
        @SerializedName("Id")
        val id : Int,
        @SerializedName("OriginStation")
        val originStation : Int,
        @SerializedName("DestinationStation")
        val destinationStation : Int,
        @SerializedName("DepartureDateTime")
        val departureDateTime : String,
        @SerializedName("ArrivalDateTime")
        val arrivalDateTime : String,
        @SerializedName("Carrier")
        val carrier : Int,
        @SerializedName("OperatingCarrier")
        val operatingCarrier : Int,
        @SerializedName("Duration")
        val duration : Int,
        @SerializedName("FlightNumber")
        val flightNumber : String,
        @SerializedName("JourneyMode")
        val journeyMode : String,
        @SerializedName("Directionality")
        val directionality : String
)