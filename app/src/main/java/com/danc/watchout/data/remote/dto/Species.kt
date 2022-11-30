package com.danc.watchout.data.remote.dto

data class Species(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<SpeciesResult>
)