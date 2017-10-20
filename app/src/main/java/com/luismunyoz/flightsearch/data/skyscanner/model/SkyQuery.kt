package com.luismunyoz.flightsearch.data.skyscanner.model

import com.google.gson.annotations.SerializedName

/**
 * Created by llco on 25/09/2017.
 */
class SkyQuery(
        @SerializedName("Country")
        val country : String,
        @SerializedName("Currency")
        val currency: String,
        @SerializedName("Locale")
        val locale : String,
        @SerializedName("Adults")
        val adults : Int,
        @SerializedName("Children")
        val children : Int,
        @SerializedName("Infants")
        val infants : Int,
        @SerializedName("OriginPlace")
        val originPlace : String,
        @SerializedName("DestinationPlace")
        val destinationPlace : String,
        @SerializedName("OutboundDate")
        val outboundDate : String,
        @SerializedName("InboundDate")
        val inboundDate : String,
        @SerializedName("LocationSchema")
        val locationSchema : String,
        @SerializedName("CabinClass")
        val cabinClass : String,
        @SerializedName("GroupPricing")
        val groupPricing : String
)