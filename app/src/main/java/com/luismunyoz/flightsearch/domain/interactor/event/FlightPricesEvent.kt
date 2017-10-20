package com.luismunyoz.flightsearch.domain.interactor.event

import com.luismunyoz.flightsearch.domain.entity.FlightPrices
import com.luismunyoz.flightsearch.domain.interactor.base.Event

/**
 * Created by Luism on 27/09/2017.
 */
data class FlightPricesEvent(val flightPrices : FlightPrices?) : Event