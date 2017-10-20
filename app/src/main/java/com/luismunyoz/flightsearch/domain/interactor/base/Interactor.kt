
package com.luismunyoz.flightsearch.domain.interactor.base

interface Interactor {

    operator fun invoke(): Event
}