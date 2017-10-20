package com.luismunyoz.flightsearch.domain.entity

/**
 * Created by Luis on 25/09/2017.
 */
class Currency(
    val code: String,
    val symbol : String,
    val thousandSeparator : String,
    val decimalSeparator : String,
    val symbolOnLeft : Boolean,
    val spaceBetweenAmountAndSymbol : Boolean,
    val roundingCoefficient : Int,
    val decimalDigits : Int
)