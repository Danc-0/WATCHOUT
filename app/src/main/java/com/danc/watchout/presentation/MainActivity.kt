package com.danc.watchout.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.danc.watchout.presentation.ui.theme.WATCHOUTTheme
import com.danc.watchout.presentation.viewmodels.PeopleViewModel
import com.danc.watchout.utils.NavigationGraph
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlin.math.log

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WATCHOUTTheme {

                val viewModel: PeopleViewModel = hiltViewModel()
                val state = viewModel.state.value
                val scaffoldState = rememberScaffoldState()

                val navController = rememberNavController()
                NavigationGraph(navController = navController)

                LaunchedEffect(key1 = true) {
                    viewModel.sharedEventFlow.collectLatest { event ->
                        when (event) {
                            is PeopleViewModel.UIEvent.ShowSnackBar -> {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = event.message
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
