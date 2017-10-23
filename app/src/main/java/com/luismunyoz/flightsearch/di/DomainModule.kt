package com.luismunyoz.flightsearch.di

import com.luismunyoz.flightsearch.domain.interactor.GetFlightPricesInteractor
import com.luismunyoz.flightsearch.domain.interactor.SearchPlacesInteractor
import com.luismunyoz.flightsearch.domain.repository.FlightSearchRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideFlightPricesInteractor(flightSearchRepository: FlightSearchRepository)
            = GetFlightPricesInteractor(flightSearchRepository)

    @Provides
    fun provideSearchPlacesInteractor(flightSearchRepository: FlightSearchRepository)
            = SearchPlacesInteractor(flightSearchRepository)
}