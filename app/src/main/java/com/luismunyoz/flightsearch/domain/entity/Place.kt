package com.luismunyoz.flightsearch.domain.entity

/**
 * Created by Luis on 25/09/2017.
 */
class Place (
        val id : Int,
        val parentId : Int,
        val code : String,
        val type : String,
        val name : String
)