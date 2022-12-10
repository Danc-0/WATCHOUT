package com.danc.watchout.presentation.screens

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
import androidx.paging.compose.itemsIndexed
import com.danc.watchout.presentation.viewmodels.VehicleViewModel

@Composable
fun VehicleScreen(navController: NavController) {

    val scaffoldState = rememberScaffoldState()
    val viewModel: VehicleViewModel = hiltViewModel()
    val vehiclesPage = viewModel.vehiclePager.collectAsLazyPagingItems()

    Scaffold(
        scaffoldState = scaffoldState,
        content = {
            Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    content = {

                        Text(
                            text = "Star War Vehicles",
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
                                itemsIndexed(vehiclesPage) { index, item ->
                                    Text(text = "Item index is $index and Item is $item",
                                        style = TextStyle(
                                            color = MaterialTheme.colors.primary
                                        )
                                    )
                                }

                                if (vehiclesPage.loadState.append == LoadState.Loading){
                                    item {
                                        Text(text = "Wait. Loading data from the Backend")
                                    }
                                }

                                if (vehiclesPage.loadState.refresh == LoadState.Loading){
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
                )
            }
        }
    )
}

