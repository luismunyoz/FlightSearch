package com.luismunyoz.flightsearch.domain.interactor.base

interface Bus {
    fun post(event: Any): Unit
    fun register(observer: Any): Unit
    fun unregister(observer: Any): Unit
}