package com.danc.watchout.domain.models

data class Peoples(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PeoplesResult>
)
