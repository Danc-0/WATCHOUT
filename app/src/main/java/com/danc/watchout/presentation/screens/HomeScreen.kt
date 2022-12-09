package com.danc.watchout.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.danc.watchout.R
import com.danc.watchout.presentation.navigation.MainAppRoutes
import com.danc.watchout.presentation.ui.components.SinglePersonComponent
import com.danc.watchout.presentation.viewmodels.PeopleViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: PeopleViewModel) {
    val peopleList = viewModel.peoples.collectAsLazyPagingItems()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
    ) { it ->
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
                    text = "People",
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

                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    columns = GridCells.Fixed(2)
                ) {

                    items(peopleList.itemCount) { item ->
                        peopleList[item]?.let { people ->
                            SinglePersonComponent(
                                person = people,
                                onClickedItem = {
                                    viewModel.peopleDetails(people)
                                    navController.navigate(MainAppRoutes.PeopleDetails.route)
                                }
                            )
                        }
                    }

                    when (peopleList.loadState.prepend) {
                        is LoadState.NotLoading -> Unit

                        is LoadState.Loading -> {
                            item {
                                LoadingItem()
                            }
                        }

                        is LoadState.Error -> {
                            item {
                                ErrorItem(message = "Unknown Error Occurred")
                            }
                        }
                    }

                    when (val state = peopleList.loadState.refresh) {
                        is LoadState.NotLoading -> Unit

                        is LoadState.Loading -> {
                            item {
                                LoadingItem()
                            }
                        }

                        is LoadState.Error -> {
                            item {
                                ErrorItem(message = state.error.message ?: "")
                            }
                        }
                    }

                    when (val state = peopleList.loadState.append) {
                        is LoadState.NotLoading -> Unit

                        is LoadState.Loading -> {
                            item {
                                LoadingItem()
                            }
                        }

                        is LoadState.Error -> {
                            item {
                                ErrorItem(message = state.error.message ?: "")
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun LoadingItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .padding(5.dp),
            strokeWidth = 2.dp
        )

    }
}

@Composable
fun ErrorItem(message: String) {
    Card(
        elevation = 2.dp,
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .width(42.dp)
                    .height(42.dp),
                painter = painterResource(id = R.drawable.warning),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White)
            )
            Text(
                color = Color.White,
                text = message,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(CenterVertically)
            )
        }
    }
}