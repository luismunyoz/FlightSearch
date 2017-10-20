package com.luismunyoz.flightsearch.data.skyscanner.requests

import com.luismunyoz.flightsearch.BuildConfig

/**
 * Created by Luis on 25/09/2017.
 */
data class FlightPricesRequest(
        var cabinclass : String = "Economy",
        var country : String = "UK",
        var currency: String = "GBP",
        var locale : String = "en-GB",
        var locationSchema : String = "sky",
        var originplace : String = "EDI-sky",
        var destinationplace : String = "LOND-sky",
        var outbounddate : String,
        var inbounddate : String,
        var adults : Int = 1,
        var children : Int = 0,
        var infants : Int = 0,
        var apikey : String = BuildConfig.APIKEY
)