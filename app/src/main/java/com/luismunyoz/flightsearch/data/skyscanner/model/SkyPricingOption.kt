package com.luismunyoz.flightsearch.data.skyscanner.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

/**
 * Created by llco on 25/09/2017.
 */
class SkyPricingOption(
        @SerializedName("Agents")
        val agents : List<Int>,
        @SerializedName("QuoteAgeInMinutes")
        val quoteAgeInMinutes : Int,
        @SerializedName("Price")
        val price : BigDecimal
)