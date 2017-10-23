package com.luismunyoz.flightsearch.di

import com.luismunyoz.flightsearch.data.CloudFlightPricesDataSet
import com.luismunyoz.flightsearch.data.skyscanner.SkyscannerAPIService
import com.luismunyoz.flightsearch.di.qualifier.ApiKey
import com.luismunyoz.flightsearch.domain.repository.FlightSearchRepository
import com.luismunyoz.flightsearch.repository.FlightSearchRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides @Singleton
    fun provideFlightSearchRepo(skyscannerAPIService: SkyscannerAPIService, @ApiKey apiKey: String) : FlightSearchRepository
            = FlightSearchRepositoryImpl(listOf(CloudFlightPricesDataSet(skyscannerAPIService, apiKey)))

}