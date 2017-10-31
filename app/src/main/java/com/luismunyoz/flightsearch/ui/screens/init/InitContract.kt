package com.luismunyoz.flightsearch.ui.screens.init

import com.luismunyoz.flightsearch.domain.entity.SearchPlace
import com.luismunyoz.flightsearch.ui.entity.UIFlightPrices
import com.luismunyoz.flightsearch.ui.entity.UIItinerary
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace
import com.luismunyoz.flightsearch.ui.util.BaseContract
import java.util.*

/**
 * Created by llco on 20/10/2017.
 */
interface InitContract {

    interface View : BaseContract.BaseView<Presenter> {

        fun populateOriginPlace(place: UISearchPlace?)

        fun populateDestinationPlace(place: UISearchPlace?)

        fun openSearchPlace(isOrigin : Boolean)

        fun openCalendar(isOrigin: Boolean)

        fun enableSearchButton(enable: Boolean)

        fun populateDepartDate(dateString : String)

        fun populateReturnDate(dateString: String)

        fun showErrorDates()

        fun goToSearch(origin: SearchPlace, destination: SearchPlace, departDate : Calendar, returnDate : Calendar)

    }

    interface Presenter : BaseContract.BasePresenter {

        fun onOriginPressed()

        fun onDestinationPressed()

        fun onSwitchPlacesPressed()

        fun onOriginPlaceSelected(place : SearchPlace)

        fun onDestinationPlaceSelected(place : SearchPlace)

        fun onDepartDatePressed()

        fun onReturnDatePressed()

        fun onDepartDateSelected(calendar: Calendar)

        fun onReturnDateSelected(calendar: Calendar)

        fun onSearchPressed()

    }

}