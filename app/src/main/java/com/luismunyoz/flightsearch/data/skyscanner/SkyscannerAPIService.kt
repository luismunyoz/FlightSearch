package com.luismunyoz.flightsearch.data.skyscanner

import com.luismunyoz.flightsearch.data.skyscanner.model.SkyscannerResponse
import com.luismunyoz.flightsearch.data.skyscanner.requests.FlightPricesSessionResponse
import com.luismunyoz.flightsearch.data.skyscanner.requests.PlacesResponse
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by Luis on 25/09/2017.
 */
interface SkyscannerAPIService {

    @FormUrlEncoded
    @POST("pricing/v1.0")
    fun getFlightPricesSession(@Field("cabinclass") cabinclass : String,
                               @Field("country") country : String,
                               @Field("currency") currency : String,
                               @Field("locale") locale : String,
                               @Field("locationSchema") locationSchema : String,
                               @Field("originplace") originplace : String,
                               @Field("destinationplace") destinationplace : String,
                               @Field("outbounddate") outbounddate : String,
                               @Field("inbounddate") inbounddate : String,
                               @Field("adults") adults : Int,
                               @Field("children") children : Int,
                               @Field("infants") infants : Int,
                               @Field("apikey") apikey : String) : Call<FlightPricesSessionResponse>

    @GET
    fun getFlightPrices(@Url location : String,
                        @Query("apiKey") apiKey : String,
                        @Query("pageIndex") pageIndex : Int = 0,
                        @Query("pageSize") pageSize : Int = 10): Call<SkyscannerResponse>

    @GET("autosuggest/v1.0/{country}/{country}/{locale}")
    fun getPlaces(@Path("country") market : String,
                  @Path("currency") currency: String,
                  @Path("locale") locale: String,
                  @Query("query") query: String,
                  @Query("apiKey") apiKey: String) : Call<PlacesResponse>
}