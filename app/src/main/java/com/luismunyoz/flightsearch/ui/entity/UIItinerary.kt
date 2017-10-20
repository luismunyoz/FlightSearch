package com.luismunyoz.flightsearch.ui.entity

import android.content.Context
import com.luismunyoz.flightsearch.R

/**
 * Created by Luis on 01/10/2017.
 */
class UIItinerary(
    val outboundLeg : UILeg,
    val inboundLeg : UILeg,
    val price : String,
    val agent : String
) {
    fun agentVerbose(context : Context) : String {
        return context.getString(R.string.via_agent).format(agent)
    }
}