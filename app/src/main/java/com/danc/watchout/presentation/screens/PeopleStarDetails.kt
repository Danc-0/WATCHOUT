package com.danc.watchout.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.danc.watchout.domain.models.PeoplesResult
import com.danc.watchout.domain.models.SpecificFilmResult
import com.danc.watchout.presentation.viewmodels.PeopleViewModel
import com.danc.watchout.presentation.viewmodels.SpecificFilmViewModel
import kotlin.random.Random

@Composable
fun PeopleStarDetails(
    viewModel: PeopleViewModel
) {
    val peopleDetails = viewModel.peopleResult
    val specificFilmViewModel: SpecificFilmViewModel = hiltViewModel()
    specificFilmViewModel.loadFilms(peopleDetails.value?.films!!)
    val viewState = specificFilmViewModel.state.collectAsState()

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier.padding(top = it.calculateTopPadding(), start = 10.dp, end = 10.dp)
        ) {
            DetailsCard(peopleDetails.value!!)
            if (viewState.value.specificFilm != null) {
                FilmCard(
                    viewState.value.specificFilm
                )
            }
        }
    }

}

@Composable
fun DetailsCard(peopleDetails: PeoplesResult) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
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
                fontSize = 15.sp,
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
    val randomColor = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
    Card(
        modifier = Modifier
            .padding(5.dp),
        elevation = 30.dp,
        backgroundColor = randomColor,
        shape = RoundedCornerShape(15.dp)
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

