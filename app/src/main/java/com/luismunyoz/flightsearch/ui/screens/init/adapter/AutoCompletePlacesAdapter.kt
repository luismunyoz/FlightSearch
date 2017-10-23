package com.luismunyoz.flightsearch.ui.screens.init.adapter

import android.content.Context
import android.widget.ArrayAdapter
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace

/**
 * Created by llco on 23/10/2017.
 */
class AutoCompletePlacesAdapter(val activityContext : Context, val places: List<UISearchPlace>) : ArrayAdapter<UISearchPlace>(activityContext, 0, places) {


}