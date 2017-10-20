package com.luismunyoz.flightsearch.data.skyscanner.model

import com.google.gson.annotations.SerializedName

/**
 * Created by llco on 25/09/2017.
 */
class SkyItinerary(
        @SerializedName("OutboundLegId")
        val outboundLegId : String,
        @SerializedName("InboundLegId")
        val inboundLegId : String,
        @SerializedName("PricingOptions")
        val pricingOptions : List<SkyPricingOption>
)