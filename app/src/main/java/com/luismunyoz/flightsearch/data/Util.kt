package com.luismunyoz.flightsearch.data

import retrofit2.Call

/**
 * Created by llco on 25/09/2017.
 */

inline fun <T, U> Call<T>.unwrapCall(f: T.() -> U) = execute().body()?.f()