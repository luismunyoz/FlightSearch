package com.luismunyoz.flightsearch.ui.screens.init

import android.os.Bundle
import android.widget.AutoCompleteTextView
import com.luismunyoz.flightsearch.R
import com.luismunyoz.flightsearch.di.ApplicationComponent
import com.luismunyoz.flightsearch.di.subcomponent.init.InitActivityModule
import com.luismunyoz.flightsearch.ui.common.BaseActivity
import com.luismunyoz.flightsearch.ui.entity.UIFlightPrices
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace

/**
 * Created by llco on 23/10/2017.
 */
class InitActivity : BaseActivity(), InitContract.View {

    lateinit var autoCompleteTextView : AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        autoCompleteTextView = findViewById(R.id.init_autocomplete)
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(InitActivityModule(this)).injectTo(this)
    }

    override fun populateSearchResults(results: List<UISearchPlace>) {
    }

}