package com.danc.watchout.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import com.danc.watchout.presentation.viewmodels.PeopleViewModel

sealed class MainAppRoutes(
    val route: String,
    val title: String,
) {

    object PeopleDetails: MainAppRoutes(
        route = "people_details",
        title = "Star Details"
    )

}
