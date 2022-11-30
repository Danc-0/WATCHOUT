package com.danc.watchout.data.remote.dto

data class Films(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<FilmsResult>
)