package com.luismunyoz.flightsearch.data.skyscanner.requests

import com.google.gson.annotations.SerializedName
import com.luismunyoz.flightsearch.data.skyscanner.model.SkySearchPlace

/**
 * Created by llco on 20/10/2017.
 */
class PlacesResponse (
    @SerializedName("Places")
    val places : List<SkySearchPlace>
)