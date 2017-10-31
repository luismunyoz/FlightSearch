package com.luismunyoz.flightsearch.ui.screens.init

import com.luismunyoz.flightsearch.domain.entity.SearchPlace
import com.luismunyoz.flightsearch.domain.interactor.SearchPlacesInteractor
import com.luismunyoz.flightsearch.domain.interactor.base.Bus
import com.luismunyoz.flightsearch.domain.interactor.base.InteractorExecutor
import com.luismunyoz.flightsearch.domain.interactor.event.SearchPlacesEvent
import com.luismunyoz.flightsearch.ui.entity.UISearchPlace
import com.luismunyoz.flightsearch.ui.entity.mapper.UISearchPlaceMapper
import java.text.DateFormat
import java.util.*

/**
 * Created by llco on 23/10/2017.
 */
class InitPresenter(val view: InitContract.View,
                    override val bus: Bus,
                    val uiSearchPlaceMapper: UISearchPlaceMapper) : InitContract.Presenter {

    var origin : SearchPlace? = null
    var destination : SearchPlace? = null
    var departDate : Calendar? = null
    var returnDate : Calendar? = null

    override fun onOriginPressed() {
        view.openSearchPlace(true)
    }

    override fun onDestinationPressed() {
        view.openSearchPlace(false)
    }

    override fun onSwitchPlacesPressed() {
        val aux = origin
        origin = destination
        destination = aux

        if(origin != null){
            view.populateOriginPlace(uiSearchPlaceMapper.transform(origin!!))
        } else {
            view.populateOriginPlace(null)
        }

        if(destination != null){
            view.populateDestinationPlace(uiSearchPlaceMapper.transform(destination!!))
        } else {
            view.populateDestinationPlace(null)
        }
        checkFields()
    }

    override fun onOriginPlaceSelected(place: SearchPlace) {
        origin = place
        view.populateOriginPlace(uiSearchPlaceMapper.transform(place))
        checkFields()
    }

    override fun onDestinationPlaceSelected(place: SearchPlace) {
        destination = place
        view.populateDestinationPlace(uiSearchPlaceMapper.transform(place))
        checkFields()
    }

    override fun onDepartDatePressed() {
        view.openCalendar(true)
    }

    override fun onReturnDatePressed() {
        view.openCalendar(false)
    }

    override fun onDepartDateSelected(calendar: Calendar) {
        departDate = calendar
        checkFields()

        val df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault())
        view.populateDepartDate(df.format(calendar.time))
    }

    override fun onReturnDateSelected(calendar: Calendar) {
        returnDate = calendar
        checkFields()

        val df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault())
        view.populateReturnDate(df.format(calendar.time))
    }

    override fun onSearchPressed() {
        if(allFieldsCompleted()){
            if(returnDate!!.before(departDate)){
                view.showErrorDates()
            } else {
                view.goToSearch(origin!!, destination!!, departDate!!, returnDate!!)
            }
        }
    }

    private fun checkFields() {
        view.enableSearchButton(allFieldsCompleted())
    }

    private fun allFieldsCompleted() : Boolean {
        return origin != null && destination != null && departDate != null && returnDate != null
    }

}