package com.danc.watchout.presentation.states

import com.danc.watchout.domain.models.Peoples

data class PeopleState(
    val allPeople: Peoples? = null,
    val isLoading: Boolean = false
)