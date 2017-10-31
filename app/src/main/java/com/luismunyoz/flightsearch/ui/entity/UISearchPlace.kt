package com.luismunyoz.flightsearch.ui.entity

/**
 * Created by llco on 20/10/2017.
 */
class UISearchPlace(
        val placeId : String,
        val placeName : String,
        val countryName : String
) {
    fun name() = "$placeName, $countryName"
}