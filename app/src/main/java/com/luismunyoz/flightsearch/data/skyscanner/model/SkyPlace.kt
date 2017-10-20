package com.luismunyoz.flightsearch.data.skyscanner.model

import com.google.gson.annotations.SerializedName

/**
 * Created by llco on 25/09/2017.
 */
class SkyPlace(
        @SerializedName("Id")
        val id : Int,
        @SerializedName("ParentId")
        val parentId : Int,
        @SerializedName("Code")
        val code : String,
        @SerializedName("Type")
        val type : String,
        @SerializedName("Name")
        val name : String
)