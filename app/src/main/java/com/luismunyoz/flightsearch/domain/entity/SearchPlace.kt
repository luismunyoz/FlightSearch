package com.luismunyoz.flightsearch.domain.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by llco on 20/10/2017.
 */
class SearchPlace(
        val placeId : String,
        val placeName : String,
        val countryId : String,
        val regionId : String,
        val cityId : String,
        val countryName : String
) : Serializable