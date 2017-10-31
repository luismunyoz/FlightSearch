package com.luismunyoz.flightsearch.ui.screens.main

import com.luismunyoz.flightsearch.domain.entity.FlightPrices
import com.luismunyoz.flightsearch.domain.interactor.GetFlightPricesInteractor
import com.luismunyoz.flightsearch.domain.interactor.base.Bus
import com.luismunyoz.flightsearch.domain.interactor.base.InteractorExecutor
import com.luismunyoz.flightsearch.domain.interactor.event.FlightPricesEvent
import com.luismunyoz.flightsearch.ui.entity.mapper.UIFlightPricesMapper
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Luism on 28/09/2017.
 */
class MainPresenter(val view: MainContract.View,
                    override val bus: Bus,
                    val getFlightPricesInteractor: GetFlightPricesInteractor,
                    val interactorExecutor: InteractorExecutor,
                    val uiFlightPricesMapper: UIFlightPricesMapper) : MainContract.Presenter {

    var flightPrices : FlightPrices? = null

    fun start(){
        if(flightPrices == null) {
            loadFlightPrices()
        }
    }

    fun loadFlightPrices(){

        view.showLoader(true)

        val apiFormatter = SimpleDateFormat("yyyy-MM-dd")
        val outboundDate = view.getDepartureDate().time
        val inboundDate = view.getReturnDate().time
        val originPlace = view.getOriginPlace()
        val destinationPlace = view.getDestinationPlace()

        getFlightPricesInteractor.outboundDate = apiFormatter.format(outboundDate)
        getFlightPricesInteractor.inboundDate = apiFormatter.format(inboundDate)
        getFlightPricesInteractor.originPlace = originPlace.placeId
        getFlightPricesInteractor.destinationPlace = destinationPlace.placeId

        interactorExecutor.execute(getFlightPricesInteractor)

        val formatter = SimpleDateFormat("dd MMM")
        view.setTitleAndSubtitle("${originPlace.placeName} - ${destinationPlace.placeName}", "${formatter.format(outboundDate)} - ${formatter.format(inboundDate)}, ${getFlightPricesInteractor.adults} adults, ${getFlightPricesInteractor.cabinClass}")

    }

    fun onEvent(event: FlightPricesEvent) {

        view.showLoader(false)

        event.flightPrices?.let {
            if(flightPrices == null) {
                this.flightPrices = event.flightPrices
                view.populateFlightPrices(uiFlightPricesMapper.transform(event.flightPrices))
            } else {
                flightPrices?.itineraries?.plus(event.flightPrices.itineraries)
                view.onMoreItinerariesLoaded(uiFlightPricesMapper.transform(event.flightPrices).itineraries)
            }
        }

        if(event.flightPrices == null){
            view.showNoResults(true)
        }
    }

    override fun onLoadMore() {
        getFlightPricesInteractor.pageIndex += 1
        interactorExecutor.execute(getFlightPricesInteractor)
    }
}