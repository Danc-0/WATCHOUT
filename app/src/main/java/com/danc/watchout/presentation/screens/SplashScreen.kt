package com.danc.watchout.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.danc.watchout.R
import com.danc.watchout.utils.ScreenRoutes

@Composable
fun SplashScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .background(MaterialTheme.colors.background)
        ) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo_animation))
            val logoAnimationState = animateLottieCompositionAsState(composition = composition)
            LottieAnimation(
                composition = composition,
                progress = { logoAnimationState.progress },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )

            if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
                navController.navigate(ScreenRoutes.Home.route)
            }

        }
    }
}