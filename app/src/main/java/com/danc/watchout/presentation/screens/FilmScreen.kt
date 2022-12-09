package com.danc.watchout.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
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
                        text = "Try not. Do or do not. There is no try",
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
                            Text(
                                text = "Indexed: ${film?.title!!}",
                                color = MaterialTheme.colors.primary,
                                fontSize = 20.sp
                            )
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
                                        message = state.error.message ?: "Unknown Error Occurred"
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
                                        message = state.error.message ?: "Unknown Error Occurred"
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