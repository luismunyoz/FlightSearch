package com.luismunyoz.flightsearch.di

import com.luismunyoz.flightsearch.domain.interactor.GetFlightPricesInteractor
import com.luismunyoz.flightsearch.domain.repository.FlightPricesRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideFlightPricesInteractor(flightPricesRepository: FlightPricesRepository)
            = GetFlightPricesInteractor(flightPricesRepository)
}