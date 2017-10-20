package com.luismunyoz.flightsearch.data.mapper

import com.luismunyoz.flightsearch.data.skyscanner.model.*
import com.luismunyoz.flightsearch.domain.entity.*

/**
 * Created by llco on 26/09/2017.
 */
class FlightPricesMapper {

    fun transform(skyscannerResponse: SkyscannerResponse) : FlightPrices {

        val agents : List<Agent> = transform(skyscannerResponse.agents)
        val carriers : List<Carrier> = transform(skyscannerResponse.carriers)
        val currencies : List<Currency> = transform(skyscannerResponse.currencies)
        val places : List<Place> = transform(skyscannerResponse.places)
        val query : Query = transform(skyscannerResponse.query)
        val flightNumbers : List<FlightNumber> = transform(skyscannerResponse.legs.flatMap { it.flightNumbers })
        val segments : List<Segment> = transform(skyscannerResponse.segments, places, carriers, flightNumbers)
        val legs : List<Leg> = transform(skyscannerResponse.legs, segments, places, carriers, flightNumbers)
        val itineraries : List<Itinerary> = transform(skyscannerResponse.itineraries, legs, agents)

        return FlightPrices(
                skyscannerResponse.sessionKey,
                query,
                skyscannerResponse.status,
                itineraries,
                currencies
        )
    }

    fun transform(query: SkyQuery) : Query = Query(query.country, query.currency, query.locale, query.adults, query.children, query.infants, query.originPlace, query.destinationPlace, query.outboundDate, query.inboundDate, query.locationSchema, query.cabinClass, query.groupPricing)

    @JvmName("transformAgent")
    fun transform(skyAgents : List<SkyAgent>) : List<Agent> = skyAgents.map { Agent(it.id, it.name, it.imageUrl, it.status, it.type) }

    @JvmName("transformCarrier")
    fun transform(skyCarriers : List<SkyCarrier>) : List<Carrier> = skyCarriers.map { Carrier(it.id, it.code, it.name, it.imageUrl, it.displayCode) }

    @JvmName("transformCurrency")
    fun transform(skyCurrencies : List<SkyCurrency>) : List<Currency> = skyCurrencies.map { Currency(it.code, it.symbol, it.thousandSeparator, it.decimalSeparator, it.symbolOnLeft, it.spaceBetweenAmountAndSymbol, it.roundingCoefficient, it.decimalDigits) }

    @JvmName("transformPlace")
    fun transform(skyPlaces : List<SkyPlace>) : List<Place> = skyPlaces.map { Place(it.id, it.parentId, it.code, it.type, it.name) }

    @JvmName("transformFlightNumber")
    fun transform(skyFlightNumbers : List<SkyFlightNumber>) : List<FlightNumber> = skyFlightNumbers.map { FlightNumber(it.flightNumber, it.carrierId) }

    @JvmName("transformSegment")
    fun transform(skySegments : List<SkySegment>, places: List<Place>, carriers: List<Carrier>, flightNumbers : List<FlightNumber>) : List<Segment> = skySegments.map { transform(it, places, carriers, flightNumbers) }

    fun transform(skySegment : SkySegment, places : List<Place>, carriers : List<Carrier>, flightNumbers: List<FlightNumber>) : Segment {
        return Segment(
                skySegment.id,
                places.filter { it.id == skySegment.originStation }.first(),
                places.filter { it.id == skySegment.destinationStation }.first(),
                skySegment.departureDateTime,
                skySegment.arrivalDateTime,
                carriers.filter { it.id == skySegment.carrier }.first(),
                carriers.filter { it.id == skySegment.operatingCarrier }.first(),
                skySegment.duration,
                skySegment.flightNumber,
                skySegment.journeyMode,
                skySegment.directionality
        )
    }

    fun transform(skyLegs: List<SkyLeg>, segments: List<Segment>, places: List<Place>, carriers: List<Carrier>, flightNumbers: List<FlightNumber>) : List<Leg> = skyLegs.map { transform(it, segments, places, carriers, flightNumbers) }

    fun transform(skyLeg : SkyLeg, segments: List<Segment>, places: List<Place>, carriers: List<Carrier>, flightNumbers: List<FlightNumber>) : Leg {
        return Leg(
                skyLeg.id,
                segments.filter { it.id in skyLeg.segmentIds },
                places.filter { it.id == skyLeg.originStation}.first(),
                places.filter { it.id == skyLeg.destinationStation }.first(),
                skyLeg.departure,
                skyLeg.arrival,
                skyLeg.duration,
                skyLeg.journeyMode,
                places.filter { it.id in skyLeg.stops },
                carriers.filter { it.id in skyLeg.carriers },
                carriers.filter { it.id in skyLeg.operatingCarriers },
                skyLeg.directionality,
                flightNumbers.filter { it.flightNumber in skyLeg.flightNumbers.map { it.flightNumber } }
        )
    }

    @JvmName("transformPricingOption")
    fun transform(skyPricingOptions : List<SkyPricingOption>, agents : List<Agent>) : List<PricingOption> = skyPricingOptions.map { transform(it, agents) }

    fun transform(skyPricingOption : SkyPricingOption, agents: List<Agent>) : PricingOption {
        return PricingOption(
                agents.filter { it.id in skyPricingOption.agents },
                skyPricingOption.price
        )
    }


    fun transform(skyItineraries : List<SkyItinerary>, legs: List<Leg>, agents: List<Agent>) : List<Itinerary> = skyItineraries.map { transform(it, legs, agents) }

    fun transform(skyItinerary : SkyItinerary, legs : List<Leg>, agents: List<Agent>) : Itinerary {
        return Itinerary(
                legs.filter { it.id == skyItinerary.outboundLegId }.first(),
                legs.filter { it.id == skyItinerary.inboundLegId }.first(),
                transform(skyItinerary.pricingOptions, agents)
        )
    }
}