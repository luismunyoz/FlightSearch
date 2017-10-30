package com.luismunyoz.flightsearch.ui.screens.search_places

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import com.luismunyoz.flightsearch.R
import com.luismunyoz.flightsearch.di.ApplicationComponent
import com.luismunyoz.flightsearch.di.subcomponent.init.InitActivityModule
import com.luismunyoz.flightsearch.di.subcomponent.search_places.SearchPlacesActivityModule
import com.luismunyoz.flightsearch.domain.entity.SearchPlace
import com.luismunyoz.flightsearch.ui.common.BaseActivity
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace
import com.luismunyoz.flightsearch.ui.screens.search_places.adapter.UISearchPlacesAdapter
import javax.inject.Inject

/**
 * Created by llco on 23/10/2017.
 */
class SearchPlacesActivity : BaseActivity(), SearchPlacesContract.View, UISearchPlacesAdapter.Callback {

    companion object {
        const val SEARCH_PLACE = "SEARCH_PLACE"
    }

    lateinit var list : RecyclerView
    lateinit var searchBox : EditText
    lateinit var searchBtn : Button

    lateinit var adapter : UISearchPlacesAdapter

    @Inject
    lateinit var presenter : SearchPlacesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_places)

        list = findViewById(R.id.search_places_list)
        searchBox = findViewById(R.id.search_places_box)
        searchBtn = findViewById(R.id.search_places_search)
        searchBtn.setOnClickListener { presenter.onSearchPressed(searchBox.text.toString()) }
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(SearchPlacesActivityModule(this)).injectTo(this)
    }

    override fun populateSearchResults(results: List<UISearchPlace>) {
        adapter = UISearchPlacesAdapter(results, this)
        val layoutManager : LinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        list.layoutManager = layoutManager
        list.adapter = adapter
    }

    override fun returnPlace(place: SearchPlace) {
        val output = Intent()
        output.putExtra(SEARCH_PLACE, place)
        setResult(Activity.RESULT_OK, output)
        finish()
    }

    override fun onItemClick(place: UISearchPlace) {
        presenter.onPlaceSelected(place)
    }

}