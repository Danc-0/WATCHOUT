package com.danc.watchout.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.danc.watchout.presentation.viewmodels.PlanetsViewModel

@Composable
fun PlanetsScreen(navController: NavController) {

    val scaffoldState = rememberScaffoldState()
    val viewModel: PlanetsViewModel = hiltViewModel()
    val planetPager = viewModel.planetPager.collectAsLazyPagingItems()

    Scaffold(
        scaffoldState = scaffoldState,
        content = {
            Box(
                modifier = Modifier.padding(it)
            ) {

                Column(
                    modifier = Modifier.padding(10.dp)
                ) {

                    Text(
                        text = "Star War Planets",
                        style = TextStyle(
                            color = MaterialTheme.colors.onSecondary,
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "A dream without ambitions is like a Car without Gas",
                        style = TextStyle(
                            color = MaterialTheme.colors.onBackground
                        )
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    LazyColumn(
                        content = {
                            item {
                                Text(
                                    text = "Still under development!!",
                                    modifier = Modifier.fillMaxWidth()
                                        .align(Alignment.CenterHorizontally),
                                    style = TextStyle(
                                        fontFamily = FontFamily.SansSerif,
                                        color = MaterialTheme.colors.primary
                                    )
                                )
                            }

                            if (planetPager.loadState.append == LoadState.Loading){
                                item {
                                    Text(text = "Wait! Loading for the data from Backend")
                                }
                            }

                            if (planetPager.loadState.refresh == LoadState.Loading){
                                item {
                                    CircularProgressIndicator(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .wrapContentWidth(Alignment.CenterHorizontally)
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
    )
}