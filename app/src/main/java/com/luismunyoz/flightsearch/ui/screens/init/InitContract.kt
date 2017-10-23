package com.luismunyoz.flightsearch.ui.screens.init

import com.luismunyoz.flightsearch.domain.entity.SearchPlace
import com.luismunyoz.flightsearch.ui.entity.UIFlightPrices
import com.luismunyoz.flightsearch.ui.entity.UIItinerary
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace
import com.luismunyoz.flightsearch.ui.util.BaseContract

/**
 * Created by llco on 20/10/2017.
 */
interface InitContract {

    interface View : BaseContract.BaseView<Presenter> {

        fun populateSearchResults(results : List<UISearchPlace>)

    }

    interface Presenter : BaseContract.BasePresenter {

        fun onSearchPressed(query : String)

    }

}