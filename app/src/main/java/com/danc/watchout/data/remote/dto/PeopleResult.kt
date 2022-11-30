package com.danc.watchout.data.remote.dto

import com.danc.watchout.domain.models.PeoplesResult
import com.google.gson.annotations.SerializedName

data class PeopleResult(
    @SerializedName("birth_year")
    val dateOfBirth: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("edited")
    val edited: String,
    @SerializedName("eye_color")
    val eyeColor: String,
    @SerializedName("films")
    val films: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("hair_color")
    val hairColor: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("homeworld")
    val homeWorld: String,
    @SerializedName("mass")
    val mass: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("skin_color")
    val skinColor: String,
    @SerializedName("species")
    val species: List<String>,
    @SerializedName("starships")
    val starShips: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("vehicles")
    val vehicles: List<String>
) {
    fun toPeoplesResult(): PeoplesResult {
        return PeoplesResult(
            dateOfBirth = dateOfBirth,
            eyeColor = eyeColor,
            films = films,
            gender = gender,
            hairColor = hairColor,
            height = height,
            name = name,
            species = species,
            starShips = starShips,
            url = url,
            vehicles = vehicles
        )
    }
}