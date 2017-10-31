package com.luismunyoz.flightsearch.ui.screens.init

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.luismunyoz.flightsearch.R
import com.luismunyoz.flightsearch.di.ApplicationComponent
import com.luismunyoz.flightsearch.di.subcomponent.init.InitActivityModule
import com.luismunyoz.flightsearch.domain.entity.SearchPlace
import com.luismunyoz.flightsearch.ui.common.BaseActivity
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace
import com.luismunyoz.flightsearch.ui.screens.main.MainActivity
import com.luismunyoz.flightsearch.ui.screens.search_places.SearchPlacesActivity
import java.util.*
import javax.inject.Inject

/**
 * Created by llco on 23/10/2017.
 */
class InitActivity : BaseActivity(), InitContract.View, DatePickerDialog.OnDateSetListener {

    companion object {
        const val SEARCH_PLACES_ORIGIN = 3201
        const val SEARCH_PLACES_DESTINATION = 3202
    }

    lateinit var originBtn : TextView
    lateinit var destinationBtn : TextView
    lateinit var switchBtn : ImageButton
    lateinit var departBtn : TextView
    lateinit var returnBtn : TextView
    lateinit var searchBtn : Button

    @Inject
    lateinit var presenter : InitPresenter

    var pickingDepartDate : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        originBtn = findViewById(R.id.init_from_box)
        destinationBtn = findViewById(R.id.init_to_box)
        switchBtn = findViewById(R.id.init_switch)
        departBtn = findViewById(R.id.init_date_departure_box)
        returnBtn = findViewById(R.id.init_date_return_box)
        searchBtn = findViewById(R.id.init_search)

        originBtn.setOnClickListener { presenter.onOriginPressed() }
        destinationBtn.setOnClickListener { presenter.onDestinationPressed() }
        switchBtn.setOnClickListener { presenter.onSwitchPlacesPressed() }
        departBtn.setOnClickListener { presenter.onDepartDatePressed() }
        returnBtn.setOnClickListener { presenter.onReturnDatePressed() }
        searchBtn.setOnClickListener { presenter.onSearchPressed() }
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(InitActivityModule(this)).injectTo(this)
    }

    override fun populateOriginPlace(place: UISearchPlace?) {
        if(place != null) {
            originBtn.text = place.name()
        } else {
            originBtn.text = getString(R.string.origin)
        }
    }

    override fun populateDestinationPlace(place: UISearchPlace?){
        if(place != null) {
            destinationBtn.text = place.name()
        } else {
            destinationBtn.text = getString(R.string.destination)
        }
    }

    override fun openSearchPlace(isOrigin: Boolean) {
        val intent = Intent(this, SearchPlacesActivity::class.java)
        startActivityForResult(intent, if(isOrigin) SEARCH_PLACES_ORIGIN else SEARCH_PLACES_DESTINATION)
    }

    override fun openCalendar(isOrigin: Boolean) {
        pickingDepartDate = isOrigin
        val calendar = Calendar.getInstance()
        val dialog = DatePickerDialog(this, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        dialog.show()
    }

    override fun enableSearchButton(enable: Boolean) {
        searchBtn.isEnabled = enable
    }

    override fun populateDepartDate(dateString: String) {
        departBtn.text = dateString
    }

    override fun populateReturnDate(dateString: String) {
        returnBtn.text = dateString
    }

    override fun goToSearch(origin: SearchPlace, destination: SearchPlace, departDate: Calendar, returnDate: Calendar) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MainActivity.ORIGIN, origin)
        intent.putExtra(MainActivity.DESTINATION, destination)
        intent.putExtra(MainActivity.DEPART, departDate)
        intent.putExtra(MainActivity.RETURN, returnDate)
        startActivity(intent)
    }

    override fun showErrorDates() {
        Toast.makeText(this, getString(R.string.return_date_after), Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK){
            when(requestCode) {
                SEARCH_PLACES_ORIGIN -> presenter.onOriginPlaceSelected(data?.getSerializableExtra(SearchPlacesActivity.SEARCH_PLACE) as SearchPlace)
                SEARCH_PLACES_DESTINATION -> presenter.onDestinationPlaceSelected(data?.getSerializableExtra(SearchPlacesActivity.SEARCH_PLACE) as SearchPlace)
            }
        }
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, p1)
        calendar.set(Calendar.MONTH, p2)
        calendar.set(Calendar.DAY_OF_MONTH, p3)

        if(pickingDepartDate){
            presenter.onDepartDateSelected(calendar)
        } else {
            presenter.onReturnDateSelected(calendar)
        }
    }
}