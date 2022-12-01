package com.danc.watchout.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.danc.watchout.presentation.navigation.StartNavigationGraph
import com.danc.watchout.presentation.ui.theme.WATCHOUTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WATCHOUTTheme {
                val navController = rememberNavController()
                StartNavigationGraph(navController = navController)

            }
        }
    }
}

