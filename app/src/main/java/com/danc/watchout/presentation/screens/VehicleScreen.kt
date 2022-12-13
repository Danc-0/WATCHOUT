package com.danc.watchout.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.danc.watchout.domain.models.VehiclesResult
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
                                    item?.let { vehicleResult ->
                                        SingleVehicleItem(vehiclesResult = vehicleResult)
                                    }
                                }

                                if (vehiclesPage.loadState.append == LoadState.Loading) {
                                    item {
                                        Text(text = "Wait. Loading data from the Backend")
                                    }
                                }

                                if (vehiclesPage.loadState.refresh == LoadState.Loading) {
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

@Composable
fun SingleVehicleItem(vehiclesResult: VehiclesResult) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.onSurface),
                shape = RoundedCornerShape(20.dp)
            ),
        content = {
            Column(
                modifier = Modifier.padding(10.dp),
                content = {
                    Row(
                        content = {
                            Text(
                                text = "Name: ".uppercase(), style = TextStyle(
                                    color = MaterialTheme.colors.onBackground
                                )
                            )
                            Text(
                                text = vehiclesResult.name.uppercase(), style = TextStyle(
                                    color = MaterialTheme.colors.onBackground,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    )

                    Row(
                        content = {
                            Text(
                                text = "Created: ".uppercase(), style = TextStyle(
                                    color = MaterialTheme.colors.onBackground
                                )
                            )
                            Text(
                                text = vehiclesResult.created, style = TextStyle(
                                    color = MaterialTheme.colors.onBackground,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    )

                    Divider(
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxWidth(),
                        color = MaterialTheme.colors.onSurface
                    )

                    Text(
                        text = "Features",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,

                            )
                    )
                    SingleFeatureItem("Vehicle Class", feature = vehiclesResult.vehicle_class)
                    SingleFeatureItem("Vehicle Model", feature = vehiclesResult.model)
                    SingleFeatureItem("Vehicle Speed", feature = vehiclesResult.max_atmosphering_speed)
                    SingleFeatureItem("Vehicle Cost", feature = vehiclesResult.cost_in_credits)
                    SingleFeatureItem("Passengers", feature = vehiclesResult.passengers)
                }
            )
        }
    )
}

@Composable
fun SingleFeatureItem(featureTag: String, feature: String) {
    Column {
        Row {
            Text(text = "${featureTag.uppercase()}: ")
            Text(text = feature)
        }
    }
}