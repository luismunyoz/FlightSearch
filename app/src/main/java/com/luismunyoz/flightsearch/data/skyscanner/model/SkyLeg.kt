package com.luismunyoz.flightsearch.data.skyscanner.model

import com.google.gson.annotations.SerializedName

/**
 * Created by llco on 25/09/2017.
 */
class SkyLeg(
        @SerializedName("Id")
        val id : String,
        @SerializedName("SegmentIds")
        val segmentIds : List<Int>,
        @SerializedName("OriginStation")
        val originStation : Int,
        @SerializedName("DestinationStation")
        val destinationStation : Int,
        @SerializedName("Departure")
        val departure : String,
        @SerializedName("Arrival")
        val arrival : String,
        @SerializedName("Duration")
        val duration : Int,
        @SerializedName("JourneyMode")
        val journeyMode : String,
        @SerializedName("Stops")
        val stops : List<Int>,
        @SerializedName("Carriers")
        val carriers : List<Int>,
        @SerializedName("OperatingCarriers")
        val operatingCarriers : List<Int>,
        @SerializedName("Directionality")
        val directionality : String,
        @SerializedName("FlightNumbers")
        val flightNumbers : List<SkyFlightNumber>
)