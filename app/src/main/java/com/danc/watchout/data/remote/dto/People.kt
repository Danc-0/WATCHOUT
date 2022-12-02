package com.danc.watchout.data.remote.dto

import com.danc.watchout.domain.models.Peoples

data class People(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PeopleResult>
) {
    fun toPeoplesResult(): Peoples {
        return Peoples(
            count = count,
            next = next,
            previous = previous,
            results = results.map { it.toPeoplesResult() }
        )
    }
}