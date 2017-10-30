package com.luismunyoz.flightsearch.ui.screens.search_places.adapter

import com.luismunyoz.flightsearch.R
import com.luismunyoz.flightsearch.ui.entity.UIItinerary
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace
import com.luismunyoz.flightsearch.ui.util.BaseAdapter

/**
 * Created by llco on 12/09/2017.
 */
class UISearchPlacesAdapter(var items: List<UISearchPlace>, var callback: Callback) : BaseAdapter() {

    override fun getItemForPosition(position: Int): Any {
        return items.get(position)
    }

    override fun getListener(): Any {
        return callback
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.layout_search_place_item
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun add(itineraries : List<UISearchPlace>) {
        val size = items.size
        items = items.plus(itineraries)
        notifyItemRangeInserted(size - 1, itineraries.size)
    }

    public interface Callback {
        fun onItemClick(place: UISearchPlace)
    }
}