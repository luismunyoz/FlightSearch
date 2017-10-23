package com.luismunyoz.flightsearch.domain.interactor

import com.luismunyoz.flightsearch.domain.interactor.base.Event
import com.luismunyoz.flightsearch.domain.interactor.base.Interactor
import com.luismunyoz.flightsearch.domain.interactor.event.FlightPricesEvent
import com.luismunyoz.flightsearch.domain.repository.FlightSearchRepository

/**
 * Created by Luism on 27/09/2017.
 */
class GetFlightPricesInteractor(val flightSearchRepository: FlightSearchRepository) : Interactor {

    var cabinClass : String = "Economy"
    var country : String = "UK"
    var currency : String = "GBP"
    var locale : String = "en-GB"
    var locationSchema : String = "sky"
    var originPlace : String = "EDI-sky"
    var destinationPlace : String = "LOND-sky"
    var outboundDate : String? = null
    var inboundDate : String? = null
    var adults : Int = 1
    var children : Int = 0
    var infants : Int = 0

    var pageIndex : Int = 0
    var pageSize : Int = 10

    override fun invoke(): Event {
        val outboundDate = this.outboundDate ?: throw IllegalStateException("Outbound Date can't be null")
        val inboundDate = this.inboundDate ?: throw IllegalStateException("Inbound Date can't be null")

        val flightPrices = flightSearchRepository.getFlightPrices(this.cabinClass, this.country, this.currency, this.locale, this.locationSchema, this.originPlace, this.destinationPlace, outboundDate, inboundDate, this.adults, this.children, this.infants, this.pageIndex, this.pageSize)
        return FlightPricesEvent(flightPrices)
    }

}