package com.luismunyoz.flightsearch.di

import com.luismunyoz.flightsearch.data.CloudFlightPricesDataSet
import com.luismunyoz.flightsearch.data.skyscanner.SkyscannerAPIService
import com.luismunyoz.flightsearch.di.qualifier.ApiKey
import com.luismunyoz.flightsearch.domain.repository.FlightPricesRepository
import com.luismunyoz.flightsearch.repository.FlightPricesRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides @Singleton
    fun provideFlightPricesRepo(skyscannerAPIService: SkyscannerAPIService, @ApiKey apiKey: String) : FlightPricesRepository
            = FlightPricesRepositoryImpl(listOf(CloudFlightPricesDataSet(skyscannerAPIService, apiKey)))

}