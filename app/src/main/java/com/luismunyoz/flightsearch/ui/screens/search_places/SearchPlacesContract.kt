package com.luismunyoz.flightsearch.ui.screens.search_places

import com.luismunyoz.flightsearch.domain.entity.SearchPlace
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace
import com.luismunyoz.flightsearch.ui.util.BaseContract

/**
 * Created by llco on 20/10/2017.
 */
interface SearchPlacesContract {

    interface View : BaseContract.BaseView<Presenter> {

        fun populateSearchResults(results : List<UISearchPlace>)

        fun returnPlace(place : SearchPlace)

    }

    interface Presenter : BaseContract.BasePresenter {

        fun onSearchPressed(query : String)

        fun onPlaceSelected(place : UISearchPlace)

    }

}