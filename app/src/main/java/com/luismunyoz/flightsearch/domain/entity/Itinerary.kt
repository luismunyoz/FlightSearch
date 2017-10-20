package com.luismunyoz.flightsearch.domain.entity

/**
 * Created by Luis on 25/09/2017.
 */
class Itinerary(
        val outboundLeg : Leg,
        val inboundLeg : Leg,
        val pricingOptions : List<PricingOption>
)