package com.luismunyoz.flightsearch.data.skyscanner.model

import com.google.gson.annotations.SerializedName

/**
 * Created by llco on 25/09/2017.
 */
class SkyCarrier(
        @SerializedName("Id")
        val id : Int,
        @SerializedName("Code")
        val code : String,
        @SerializedName("Name")
        val name : String,
        @SerializedName("ImageUrl")
        val imageUrl : String,
        @SerializedName("DisplayCode")
        val displayCode : String
)