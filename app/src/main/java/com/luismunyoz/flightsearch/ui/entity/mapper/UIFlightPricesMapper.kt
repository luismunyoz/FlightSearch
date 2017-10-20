package com.luismunyoz.flightsearch.ui.entity.mapper

import com.luismunyoz.flightsearch.domain.entity.*
import com.luismunyoz.flightsearch.ui.entity.UIFlightPrices
import com.luismunyoz.flightsearch.ui.entity.UIItinerary
import com.luismunyoz.flightsearch.ui.entity.UILeg
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

/**
 * Created by Luism on 28/09/2017.
 */
class UIFlightPricesMapper {

    fun transform(flightPrices: FlightPrices) : UIFlightPrices {
        return UIFlightPrices(
                transform(flightPrices.itineraries, flightPrices.currencies)
        )
    }

    fun transform(itineraries : List<Itinerary>, currencies : List<Currency>) : List<UIItinerary> {
        return itineraries.map { transform(it, currencies) }
    }

    fun transform(itinerary : Itinerary, currencies : List<Currency>) : UIItinerary = UIItinerary(transform(itinerary.inboundLeg), transform(itinerary.outboundLeg), transform(itinerary.pricingOptions.first(), currencies.first()), itinerary.pricingOptions.first().agents.first().name)

    fun transform(leg : Leg) : UILeg {
        return UILeg(
                leg.carriers[0].imageUrl,
                leg.carriers[0].name,
                leg.originStation.code,
                leg.destinationStation.code,
                leg.departure,
                leg.arrival,
                leg.segments.size - 1,
                leg.duration
        )
    }

    fun transform(pricingOption : PricingOption, currency : Currency) : String {
        var result : String = ""
        if(currency.symbolOnLeft){
            result += currency.symbol
            if(currency.spaceBetweenAmountAndSymbol) {
                result += " "
            }
        }
        val symbols = DecimalFormatSymbols.getInstance()
        symbols.decimalSeparator = currency.decimalSeparator[0]
        symbols.groupingSeparator = currency.thousandSeparator[0]
        result += DecimalFormat("0.00", symbols).format(pricingOption.price)
        if(!currency.symbolOnLeft){
            if(currency.spaceBetweenAmountAndSymbol) {
                result += " "
            }
            result += currency.symbol
        }
        return result
    }
}