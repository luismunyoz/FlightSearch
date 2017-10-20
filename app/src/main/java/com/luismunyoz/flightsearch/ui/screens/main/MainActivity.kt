package com.luismunyoz.flightsearch.ui.screens.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.widget.TextView
import com.luismunyoz.flightsearch.R
import com.luismunyoz.flightsearch.di.ApplicationComponent
import com.luismunyoz.flightsearch.di.subcomponent.main.MainActivityModule
import com.luismunyoz.flightsearch.ui.common.BaseActivity
import com.luismunyoz.flightsearch.ui.entity.UIFlightPrices
import com.luismunyoz.flightsearch.ui.entity.UIItinerary
import com.luismunyoz.flightsearch.ui.screens.main.adapter.UIItinerariesAdapter
import com.luismunyoz.flightsearch.ui.util.EndlessRecyclerViewScrollListener
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View, UIItinerariesAdapter.Callback {
    lateinit var list : RecyclerView
    lateinit var adapter : UIItinerariesAdapter
    lateinit var toolbar : Toolbar
    lateinit var resultsTV : TextView

    @Inject
    lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = findViewById(R.id.main_results_list)
        toolbar = findViewById(R.id.main_toolbar)
        resultsTV = findViewById(R.id.main_results_number)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun setTitleAndSubtitle(title: String, subtitle: String) {
        supportActionBar?.title = title
        supportActionBar?.subtitle = subtitle
    }

    override fun populateFlightPrices(flightPrices: UIFlightPrices) {

        adapter = UIItinerariesAdapter(flightPrices.itineraries, this)
        val layoutManager : LinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        list.layoutManager = layoutManager
        list.addOnScrollListener(object : EndlessRecyclerViewScrollListener(layoutManager){
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                presenter.onLoadMore()
            }
        })
        list.adapter = adapter

        resultsTV.text = getString(R.string.n_results).format(adapter.itemCount)
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(MainActivityModule(this)).injectTo(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
        presenter.start()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onMoreItinerariesLoaded(itineraries: List<UIItinerary>) {
        adapter.add(itineraries)

        resultsTV.text = getString(R.string.n_results).format(adapter.itemCount)
    }
}
