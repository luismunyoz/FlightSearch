package com.luismunyoz.flightsearch.data.skyscanner.model

import com.google.gson.annotations.SerializedName

/**
 * Created by llco on 25/09/2017.
 */
class SkyFlightNumber(
        @SerializedName("FlightNumber")
        val flightNumber : String,
        @SerializedName("CarrierId")
        val carrierId : String
)