package com.luismunyoz.flightsearch.ui.screens.main.adapter

import com.luismunyoz.flightsearch.R
import com.luismunyoz.flightsearch.ui.entity.UIItinerary
import com.luismunyoz.flightsearch.ui.util.BaseAdapter


/**
 * Created by llco on 12/09/2017.
 */
class UIItinerariesAdapter(var items: List<UIItinerary>, var callback: Callback) : BaseAdapter() {

    override fun getItemForPosition(position: Int): Any {
        return items.get(position)
    }

    override fun getListener(): Any {
        return callback
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.layout_itinerary_item
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun add(itineraries : List<UIItinerary>) {
        val size = items.size
        items = items.plus(itineraries)
        //notifyDataSetChanged()
        notifyItemRangeInserted(size - 1, itineraries.size)
    }

    public interface Callback {

    }
}