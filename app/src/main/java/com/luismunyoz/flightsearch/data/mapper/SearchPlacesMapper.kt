package com.luismunyoz.flightsearch.data.mapper

import com.luismunyoz.flightsearch.data.skyscanner.model.SkySearchPlace
import com.luismunyoz.flightsearch.domain.entity.SearchPlace

/**
 * Created by llco on 23/10/2017.
 */
class SearchPlacesMapper {

    fun transform(skyPlaces: List<SkySearchPlace>) : List<SearchPlace> = skyPlaces.map { transform(it) }

    fun transform(skyPlace : SkySearchPlace) : SearchPlace = SearchPlace(skyPlace.placeId, skyPlace.placeName, skyPlace.countryId, skyPlace.regionId, skyPlace.cityId, skyPlace.countryName)
}