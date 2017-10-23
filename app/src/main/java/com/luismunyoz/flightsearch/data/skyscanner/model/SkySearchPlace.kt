package com.luismunyoz.flightsearch.data.skyscanner.model

import com.google.gson.annotations.SerializedName

/**
 * Created by llco on 20/10/2017.
 */
class SkySearchPlace (
        @SerializedName("PlaceId")
        val placeId : String,
        @SerializedName("PlaceName")
        val placeName : String,
        @SerializedName("CountryId")
        val countryId : String,
        @SerializedName("RegionId")
        val regionId : String,
        @SerializedName("CityId")
        val cityId : String,
        @SerializedName("CountryName")
        val countryName : String
)