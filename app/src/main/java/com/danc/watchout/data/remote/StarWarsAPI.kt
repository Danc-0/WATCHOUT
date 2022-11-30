package com.danc.watchout.data.remote

import com.danc.watchout.data.remote.dto.*
import retrofit2.http.GET

interface StarWarsAPI {

    @GET("people/")
    suspend fun getPeople(): People

    @GET("/films/")
    suspend fun getFilms(): Films

    @GET("/vehicles/")
    suspend fun getVehicles(): Vehicles

    @GET("/planets/")
    suspend fun getPlanets(): Planets

    @GET("/species/")
    suspend fun getSpecies(): Species

    @GET("/starships/")
    suspend fun getStarships(): StarShips

}