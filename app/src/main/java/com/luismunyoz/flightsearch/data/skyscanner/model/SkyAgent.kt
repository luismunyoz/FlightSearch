package com.luismunyoz.flightsearch.data.skyscanner.model

import com.google.gson.annotations.SerializedName

/**
 * Created by llco on 25/09/2017.
 */
class SkyAgent(
        @SerializedName("Id")
        val id : Int,
        @SerializedName("Name")
        val name : String,
        @SerializedName("ImageUrl")
        val imageUrl : String,
        @SerializedName("Status")
        val status : String,
        @SerializedName("OptimisedForMobile")
        val optimisedForMobile : Boolean,
        @SerializedName("BookingNumber")
        val bookingNumber : String,
        @SerializedName("Type")
        val type : String
)