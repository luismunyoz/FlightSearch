package com.luismunyoz.flightsearch.domain.entity

import java.math.BigDecimal

/**
 * Created by Luis on 25/09/2017.
 */
class PricingOption (
        val agents : List<Agent>,
        val price : BigDecimal
)