package com.luismunyoz.flightsearch.ui.screens.init.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace

/**
 * Created by llco on 23/10/2017.
 */
class AutoCompletePlacesAdapter(val activityContext : Context, val places: List<UISearchPlace>) : ArrayAdapter<UISearchPlace>(activityContext, 0, places) {

    var filteredPlaces : List<UISearchPlace> = ArrayList()

    init {
        filteredPlaces.plus(places)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return super.getView(position, convertView, parent)
    }

    override fun getFilter(): Filter {
        return SearchPlacesFilter(this, places)
    }

    override fun getCount(): Int {
        return filteredPlaces.size
    }
}