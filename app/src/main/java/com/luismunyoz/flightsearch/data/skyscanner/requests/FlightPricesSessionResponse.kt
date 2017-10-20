package com.luismunyoz.flightsearch.data.skyscanner.requests

import com.google.gson.annotations.SerializedName

/**
 * Created by Luis on 01/10/2017.
 */
class FlightPricesSessionResponse(
        @SerializedName("ServiceQuery") val serviceQuery : Map<String, String>
)