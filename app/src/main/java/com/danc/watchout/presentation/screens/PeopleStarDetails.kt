package com.danc.watchout.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.danc.watchout.R
import com.danc.watchout.domain.models.PeoplesResult
import com.danc.watchout.domain.models.SpecificFilmResult
import com.danc.watchout.presentation.viewmodels.PeopleViewModel
import com.danc.watchout.presentation.viewmodels.SpecificFilmViewModel
import kotlin.random.Random

@Composable
fun PeopleStarDetails(
    viewModel: PeopleViewModel,
    navController: NavController
) {
    val peopleDetails = viewModel.peopleResult
    val specificFilmViewModel: SpecificFilmViewModel = hiltViewModel()
    specificFilmViewModel.loadFilms(peopleDetails.value?.films!!)
    val viewState = specificFilmViewModel.state.collectAsState()

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(navController)
        },
        content = {
            Column(
                Modifier.padding(it)
            ) {
                DetailsCard(peopleDetails.value!!)
                if (viewState.value.specificFilm != null) {
                    FilmCard(
                        viewState.value.specificFilm
                    )
                }
            }
        }
    )
}

@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        content = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back Arrow")
            }
            Text(
                text = "Character Details", style = TextStyle(
                    fontWeight = FontWeight.Bold
                )
            )
        },
    )
}

@Composable
fun DetailsCard(peopleDetails: PeoplesResult) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp),
        elevation = 20.dp,
        backgroundColor = MaterialTheme.colors.onBackground,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row {
                Text(
                    text = "Name:".uppercase(),
                    style = TextStyle(color = MaterialTheme.colors.background)
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = peopleDetails.name.uppercase(),
                    style = TextStyle(
                        color = MaterialTheme.colors.background,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(modifier = Modifier.padding(2.dp))
            Row {
                Text(
                    text = "DOB:".uppercase(),
                    style = TextStyle(color = MaterialTheme.colors.background)
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = peopleDetails.dateOfBirth,
                    style = TextStyle(
                        color = MaterialTheme.colors.background,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(modifier = Modifier.padding(2.dp))
            Row {
                Text(
                    text = "Gender:".uppercase(),
                    style = TextStyle(color = MaterialTheme.colors.background)
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = peopleDetails.gender.uppercase(),
                    style = TextStyle(
                        color = MaterialTheme.colors.background,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Divider(
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                thickness = 1.dp,
                color = MaterialTheme.colors.background
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                PeopleDescription(title = "Height", description = peopleDetails.height)
                PeopleDescription(title = "Mass", description = peopleDetails.height)
                PeopleDescription(title = "Hair Color", description = peopleDetails.hairColor)
                PeopleDescription(title = "Eye Color", description = peopleDetails.eyeColor)

            }
        }
    }
}

@Composable
fun PeopleDescription(title: String, description: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title.uppercase(),
            style = TextStyle(color = MaterialTheme.colors.background)
        )
        Text(
            text = description.uppercase(),
            style = TextStyle(
                color = MaterialTheme.colors.background,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun FilmCard(
    films: List<SpecificFilmResult>?
) {
    Column(
        modifier = Modifier.padding(
            10.dp
        )
    ) {
        Text(
            text = "Films",
            style = TextStyle(
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Bold
            )
        )
        LazyRow {
            items(films?.size!!) { index ->
                val details = films[index]
                FilmItem(filmTitle = details.title, filmDescription = details.openingCrawl)
            }
        }
    }
}

@Composable
fun FilmItem(filmTitle: String?, filmDescription: String?) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .border(
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.onSurface),
                shape = RoundedCornerShape(10.dp)
            ),
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = filmTitle!!.uppercase(), style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    textDecoration = TextDecoration.Underline
                )
            )
            Text(text = filmDescription!!)
        }

    }
}

