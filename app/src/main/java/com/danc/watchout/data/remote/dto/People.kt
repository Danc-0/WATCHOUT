package com.danc.watchout.data.remote.dto

import com.danc.watchout.domain.models.Peoples

data class People(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PeopleResult>
) {
    fun toPeoplesResult(): Peoples {
        return Peoples(
            results = results.map { it.toPeoplesResult() }
        )
    }
}