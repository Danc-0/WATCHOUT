package com.danc.watchout.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
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
                    LazyColumn(
                        content = {
                            itemsIndexed(planetPager) { index, item ->
                                Text(text = "Item is: $item")
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