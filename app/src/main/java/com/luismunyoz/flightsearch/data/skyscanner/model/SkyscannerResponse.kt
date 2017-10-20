package com.luismunyoz.flightsearch.data.skyscanner.model

import com.google.gson.annotations.SerializedName

/**
 * Created by llco on 25/09/2017.
 */
class SkyscannerResponse(
        @SerializedName("SessionKey")
        val sessionKey : String,
        @SerializedName("Query")
        val query : SkyQuery,
        @SerializedName("Status")
        val status : String,
        @SerializedName("Itineraries")
        val itineraries : List<SkyItinerary>,
        @SerializedName("Legs")
        val legs : List<SkyLeg>,
        @SerializedName("Segments")
        val segments : List<SkySegment>,
        @SerializedName("Carriers")
        val carriers : List<SkyCarrier>,
        @SerializedName("Agents")
        val agents : List<SkyAgent>,
        @SerializedName("Places")
        val places : List<SkyPlace>,
        @SerializedName("Currencies")
        val currencies: List<SkyCurrency>
)