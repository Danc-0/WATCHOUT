package com.danc.watchout.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.danc.watchout.presentation.viewmodels.StarShipsViewModel

@Composable
fun StarShipScreen(navController: NavController) {

    val scaffoldState = rememberScaffoldState()
    val viewModel: StarShipsViewModel = hiltViewModel()
    val starShipPager = viewModel.starShipPager.collectAsLazyPagingItems()

    Scaffold(
        scaffoldState = scaffoldState,
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {

            Column(
                modifier = Modifier.padding(10.dp)
            ) {

                LazyColumn(
                    content = {
                        items(starShipPager.itemCount) { item ->
                            val starShip = starShipPager[item]
                            Text(text = starShip.toString(), color = MaterialTheme.colors.primary)
                        }

                        if (starShipPager.loadState.append == LoadState.Loading){
                            item {
                                CircularProgressIndicator(
                                    modifier = Modifier.fillMaxWidth()
                                        .wrapContentWidth(Alignment.CenterHorizontally)
                                )
                            }
                        }

                        if (starShipPager.loadState.refresh == LoadState.Loading){
                            item {
                                Text(text = "Please waiting data is loading from Backend")
                            }
                        }
                    }
                )

            }

        }
    }
}