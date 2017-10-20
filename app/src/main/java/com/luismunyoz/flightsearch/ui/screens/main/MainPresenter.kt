package com.luismunyoz.flightsearch.ui.screens.main

import com.luismunyoz.flightsearch.domain.entity.FlightPrices
import com.luismunyoz.flightsearch.domain.interactor.GetFlightPricesInteractor
import com.luismunyoz.flightsearch.domain.interactor.base.Bus
import com.luismunyoz.flightsearch.domain.interactor.base.InteractorExecutor
import com.luismunyoz.flightsearch.domain.interactor.event.FlightPricesEvent
import com.luismunyoz.flightsearch.ui.entity.mapper.UIFlightPricesMapper
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

        val calendar : Calendar = Calendar.getInstance()
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, 1)
        }

        var formatter = SimpleDateFormat("yyyy-MM-dd")
        val outboundDate = calendar.time
        calendar.add(Calendar.DATE, 1)
        val inboundDate = calendar.time

        getFlightPricesInteractor.outboundDate = formatter.format(outboundDate)
        getFlightPricesInteractor.inboundDate = formatter.format(inboundDate)

        interactorExecutor.execute(getFlightPricesInteractor)

        formatter = SimpleDateFormat("dd MMM")
        view.setTitleAndSubtitle("London - Edinburgh", "${formatter.format(outboundDate)} - ${formatter.format(inboundDate)}, ${getFlightPricesInteractor.adults} adults, ${getFlightPricesInteractor.cabinClass}")
    }

    fun onEvent(event: FlightPricesEvent) {
        event.flightPrices?.let {
            if(flightPrices == null) {
                this.flightPrices = event.flightPrices
                view.populateFlightPrices(uiFlightPricesMapper.transform(event.flightPrices))
            } else {
                flightPrices?.itineraries?.plus(event.flightPrices.itineraries)
                view.onMoreItinerariesLoaded(uiFlightPricesMapper.transform(event.flightPrices).itineraries)
            }
        }
    }

    override fun onLoadMore() {
        getFlightPricesInteractor.pageIndex += 1
        interactorExecutor.execute(getFlightPricesInteractor)
    }
}