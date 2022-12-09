package com.danc.watchout.domain.models

import com.google.gson.annotations.SerializedName

data class FilmsResult(
    val characters: List<String>,
    val created: String,
    val director: String,
    val edited: String,
    @SerializedName("opening_crawl")
    val openingCrawl: String,
    val planets: List<String>,
    val producer: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val species: List<String>,
    val starships: List<String>,
    val title: String,
    val vehicles: List<String>
)