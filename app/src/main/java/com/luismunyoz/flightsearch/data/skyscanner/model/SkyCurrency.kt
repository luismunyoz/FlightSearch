package com.luismunyoz.flightsearch.data.skyscanner.model

import com.google.gson.annotations.SerializedName

/**
 * Created by llco on 25/09/2017.
 */
class SkyCurrency(
        @SerializedName("Code")
        val code : String,
        @SerializedName("Symbol")
        val symbol : String,
        @SerializedName("ThousandsSeparator")
        val thousandSeparator : String,
        @SerializedName("DecimalSeparator")
        val decimalSeparator : String,
        @SerializedName("SymbolOnLeft")
        val symbolOnLeft : Boolean,
        @SerializedName("SpaceBetweenAmountAndSymbol")
        val spaceBetweenAmountAndSymbol : Boolean,
        @SerializedName("RoundingCoefficient")
        val roundingCoefficient : Int,
        @SerializedName("DecimalDigits")
        val decimalDigits : Int
)