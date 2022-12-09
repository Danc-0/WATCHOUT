package com.danc.watchout.data.remote

import com.danc.watchout.data.remote.dto.*
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface StarWarsAPI {

    @GET("people/")
    suspend fun getPeople(
        @Query("page") pageNo: Int
    ): People

    @GET("films/")
    suspend fun getFilms(
        @Query("page") pageNo: Int
    ): Films

    @GET
    suspend fun getSpecificFilms(@Url filmUrl: String): FilmsResult

    @GET("vehicles/")
    suspend fun getVehicles(
        @Query("page") pageNo: Int
    ): Vehicles

    @GET("planets/")
    suspend fun getPlanets(
        @Query("page") pageNo: Int
    ): Planets

    @GET("species/")
    suspend fun getSpecies(
        @Query("page") pageNo: Int
    ): Species

    @GET("starships/")
    suspend fun getStarships(
        @Query("page") pageNo: Int
    ): StarShips

}