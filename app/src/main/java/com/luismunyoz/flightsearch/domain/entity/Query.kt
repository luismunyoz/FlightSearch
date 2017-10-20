package com.luismunyoz.flightsearch.domain.entity

/**
 * Created by Luis on 25/09/2017.
 */
class Query(
        val country : String,
        val currency : String,
        val locale : String,
        val adults : Int,
        val children : Int,
        val infants : Int,
        val originPlace : String,
        val destinationPlace : String,
        val outboundDate : String,
        val inboundDate : String,
        val locationSchema : String,
        val cabinClass : String,
        val groupPricing : String
)