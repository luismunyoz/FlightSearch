package com.luismunyoz.flightsearch.ui.screens.main

import com.luismunyoz.flightsearch.domain.entity.SearchPlace
import com.luismunyoz.flightsearch.ui.entity.UIFlightPrices
import com.luismunyoz.flightsearch.ui.entity.UIItinerary
import com.luismunyoz.flightsearch.ui.util.BaseContract
import java.util.*

/**
 * Created by Luism on 27/09/2017.
 */
interface MainContract {

    interface View : BaseContract.BaseView<Presenter> {

        fun populateFlightPrices(flightPrices : UIFlightPrices)

        fun onMoreItinerariesLoaded(itineraries : List<UIItinerary>)

        fun setTitleAndSubtitle(title : String, subtitle: String)

        fun getOriginPlace() : SearchPlace

        fun getDestinationPlace() : SearchPlace

        fun getDepartureDate() : Calendar

        fun getReturnDate() : Calendar

        fun showLoader(show : Boolean)

        fun showNoResults(show : Boolean)

    }

    interface Presenter : BaseContract.BasePresenter {

        fun onLoadMore()
    }
}