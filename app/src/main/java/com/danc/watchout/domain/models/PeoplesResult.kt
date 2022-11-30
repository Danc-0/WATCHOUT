package com.danc.watchout.domain.models

data class PeoplesResult(
    val dateOfBirth: String,
    val eyeColor: String,
    val films: List<String>,
    val gender: String,
    val hairColor: String,
    val height: String,
    val name: String,
    val species: List<String>,
    val starShips: List<String>,
    val url: String,
    val vehicles: List<String>
)