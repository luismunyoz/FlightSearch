package com.luismunyoz.flightsearch.data

import com.luismunyoz.flightsearch.BuildConfig
import com.luismunyoz.flightsearch.data.mapper.FlightPricesMapper
import com.luismunyoz.flightsearch.data.mapper.SearchPlacesMapper
import com.luismunyoz.flightsearch.data.skyscanner.SkyscannerAPIService
import com.luismunyoz.flightsearch.domain.entity.FlightPrices
import com.luismunyoz.flightsearch.domain.entity.SearchPlace
import com.luismunyoz.flightsearch.repository.dataset.FlightPricesDataSet

/**
 * Created by Luism on 27/09/2017.
 */
class CloudFlightPricesDataSet(val skyscannerAPIService: SkyscannerAPIService, val apiKey: String) : FlightPricesDataSet {

    override fun requestFlightPrices(cabinClass : String, country: String, currency: String, locale: String, locationSchema: String, originPlace: String, destinationPlace: String, outboundDate: String, inboundDate: String, adults: Int, children: Int, infants: Int, pageIndex: Int, pageSize: Int): FlightPrices {
        val result = skyscannerAPIService.getFlightPricesSession(cabinClass, country, currency, locale, locationSchema, originPlace, destinationPlace, outboundDate, inboundDate, adults, children, infants, apiKey).execute()

        val location : String = result.headers().get("location")!!

        val finalLocation = location.drop(BuildConfig.BASE_URL.length)

        return skyscannerAPIService.getFlightPrices(finalLocation, apiKey, pageIndex, pageSize).unwrapCall {
            FlightPricesMapper().transform(this)
        } ?: throw IllegalStateException()
    }

    override fun searchPlaces(country: String, currency: String, locale: String, query: String) : List<SearchPlace> {
        return skyscannerAPIService.getPlaces(country, currency, locale, query, apiKey).unwrapCall {
            SearchPlacesMapper().transform(this.places)
        } ?: emptyList()
    }

}