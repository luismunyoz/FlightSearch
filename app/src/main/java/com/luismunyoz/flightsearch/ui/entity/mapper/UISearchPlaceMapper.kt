package com.luismunyoz.flightsearch.ui.entity.mapper

import com.luismunyoz.flightsearch.domain.entity.SearchPlace
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace

/**
 * Created by llco on 23/10/2017.
 */
class UISearchPlaceMapper {

    fun transform(searchPlaces : List<SearchPlace>) : List<UISearchPlace> = searchPlaces.map { transform(it) }

    fun transform(searchPlace : SearchPlace) : UISearchPlace = UISearchPlace(searchPlace.placeId, searchPlace.placeName, searchPlace.countryName)
}