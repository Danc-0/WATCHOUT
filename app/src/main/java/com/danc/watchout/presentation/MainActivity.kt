package com.danc.watchout.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.danc.watchout.presentation.ui.components.BottomAppBarComponent
import com.danc.watchout.presentation.ui.theme.WATCHOUTTheme
import com.danc.watchout.presentation.navigation.NavigationGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WATCHOUTTheme {
                /**
                 * Create a scaffold state that will be CLOSED as default which will help in controlling the Scaffold Components
                 * Create a coroutine scope for Opening and closing of the Drawer and SnackBar which is supposed to be handled from the Background Thread.
                 * Without BLOCKING the Main Thread
                 */
                val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
                val coroutineScope = rememberCoroutineScope()
                val navController = rememberNavController()
                MainComponent(scaffoldState = scaffoldState, navHostController = navController)

            }
        }
    }
}

@Composable
fun MainComponent(scaffoldState: ScaffoldState, navHostController: NavHostController) {
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier,
        bottomBar = {
            BottomAppBarComponent(navController = navHostController)
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(paddingValues = contentPadding)
        ) {
            NavigationGraph(navController = navHostController)
        }
    }
}
