package com.luismunyoz.flightsearch.ui.screens.init.adapter

import android.os.Handler
import android.os.Message
import android.widget.Filter
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace


/**
 * Created by llco on 23/10/2017.
 */
class SearchPlacesFilter(val autoCompletePlacesAdapter: AutoCompletePlacesAdapter, val places: List<UISearchPlace>) : Filter() {

    override fun performFiltering(p0: CharSequence?): FilterResults {
        val results = FilterResults()
        results.count = places.size
        results.values = places
        return results
    }

    override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
        autoCompletePlacesAdapter.filteredPlaces.drop(autoCompletePlacesAdapter.filteredPlaces.size)
        autoCompletePlacesAdapter.filteredPlaces.plus(p1)
        autoCompletePlacesAdapter.notifyDataSetChanged()
    }


}