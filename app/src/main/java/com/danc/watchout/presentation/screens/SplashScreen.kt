package com.danc.watchout.presentation.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.danc.watchout.R
import com.danc.watchout.presentation.MainActivity
import com.danc.watchout.presentation.navigation.ScreenRoutes

@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
        ) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo_animation))
            val logoAnimationState = animateLottieCompositionAsState(composition = composition)
            LottieAnimation(
                composition = composition,
                progress = { logoAnimationState.progress },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(300.dp),
                contentScale = ContentScale.Fit,
            )
            Text(
                text = "Star Ross",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onSecondary,
                    fontSize = 25.sp
                )
            )

            if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
                startMainActivity(context)
            }

        }
    }
}

fun startMainActivity(context: Context) {
    val intent = Intent(context, MainActivity::class.java)
    startActivity(context, intent, null)
}