package com.danc.watchout.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.danc.watchout.domain.models.FilmsResult
import com.danc.watchout.presentation.ui.components.ErrorItemComponent
import com.danc.watchout.presentation.viewmodels.FilmsViewModel

@Composable
fun FilmScreen(navController: NavController) {

    val scaffoldState = rememberScaffoldState()
    val filmsViewModel: FilmsViewModel = hiltViewModel()
    val films = filmsViewModel.filmPager.collectAsLazyPagingItems()

    Scaffold(
        scaffoldState = scaffoldState,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
                    .padding(it),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Films",
                        style = TextStyle(
                            color = MaterialTheme.colors.onSecondary,
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "May the Force be with you",
                        style = TextStyle(
                            color = MaterialTheme.colors.onBackground
                        )
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        content = {

                            items(films.itemCount) { item ->
                                val film = films[item]
                                SingleFilmItem(filmResult = film)
                            }

                            when (val state = films.loadState.prepend) {
                                is LoadState.NotLoading -> Unit
                                is LoadState.Loading -> {
                                    item {
                                        CircularProgressIndicator(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentWidth(Alignment.CenterHorizontally)
                                        )
                                    }
                                }
                                is LoadState.Error -> {
                                    item {
                                        ErrorItemComponent(
                                            message = state.error.message ?: "Unknown Error"
                                        )
                                    }
                                }
                            }

                            when (val state = films.loadState.refresh) {
                                is LoadState.NotLoading -> Unit

                                is LoadState.Loading -> {
                                    item {
                                        CircularProgressIndicator(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentWidth(Alignment.CenterHorizontally)
                                        )
                                    }
                                }

                                is LoadState.Error -> {
                                    item {
                                        ErrorItemComponent(
                                            message = state.error.message
                                                ?: "Unknown Error Occurred"
                                        )
                                    }
                                }
                            }

                            when (val state = films.loadState.prepend) {
                                is LoadState.NotLoading -> Unit

                                is LoadState.Loading -> {
                                    item {
                                        CircularProgressIndicator(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentWidth(Alignment.CenterHorizontally)
                                        )
                                    }
                                }

                                is LoadState.Error -> {
                                    item {
                                        ErrorItemComponent(
                                            message = state.error.message
                                                ?: "Unknown Error Occurred"
                                        )
                                    }


                                }

                            }

                        })
                }
            }
        }
    )
}

@Composable
fun SingleFilmItem(filmResult: FilmsResult?) {
    filmResult?.let { filmsResult ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .border(
                    border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.onSurface),
                    shape = RoundedCornerShape(20.dp)
                )
                .clickable(
                    onClick = {

                    }
                ),
            content = {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(150.dp),
                    content = {
                        Row(
                            modifier = Modifier.padding(2.dp),
                            content = {
                                Text(
                                    text = "Film Title: ".uppercase(), style = TextStyle(
                                        color = MaterialTheme.colors.onBackground
                                    )
                                )
                                Text(
                                    text = filmsResult.title.uppercase(), style = TextStyle(
                                        color = MaterialTheme.colors.onBackground,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        )

                        Row(
                            modifier = Modifier
                                .padding(2.dp)
                                .fillMaxWidth(),
                            content = {
                                Text(
                                    text = "No. of Characters ".uppercase(), style = TextStyle(
                                        color = MaterialTheme.colors.onBackground,
                                    )
                                )
                                Text(
                                    text = filmsResult.characters.size.toString(),
                                    style = TextStyle(
                                        color = MaterialTheme.colors.onBackground,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        )

                        Column(
                            modifier = Modifier.padding(2.dp),
                            content = {
                                Text(
                                    text = "Film Description: ".uppercase(), style = TextStyle(
                                        color = MaterialTheme.colors.onBackground,
                                        fontWeight = FontWeight.Bold,
                                        textDecoration = TextDecoration.Underline
                                    )
                                )
                                Text(
                                    text = filmsResult.openingCrawl, style = TextStyle(
                                        color = MaterialTheme.colors.onBackground
                                    )
                                )
                            }
                        )

                    }
                )
            }
        )
    }
}