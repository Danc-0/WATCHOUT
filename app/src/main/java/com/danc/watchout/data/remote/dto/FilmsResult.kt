package com.danc.watchout.data.remote.dto

import com.danc.watchout.domain.models.SpecificFilmResult
import com.google.gson.annotations.SerializedName

data class FilmsResult(
    val characters: List<String>,
    val created: String,
    val director: String,
    val edited: String,
    @SerializedName("episode_id")
    val episodeId: Int,
    @SerializedName("opening_crawl")
    val openingCrawl: String,
    val planets: List<String>,
    val producer: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val species: List<String>,
    val starships: List<String>,
    val title: String,
    val url: String,
    val vehicles: List<String>
) {
    fun toSpecificFilmResult(): SpecificFilmResult {
        return SpecificFilmResult(
            title = title,
            created = created,
            director = director,
            producer = producer,
            edited = edited,
            openingCrawl = openingCrawl,
            releaseDate = releaseDate
        )
    }
}