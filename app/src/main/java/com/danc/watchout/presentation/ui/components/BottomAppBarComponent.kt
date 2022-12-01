package com.danc.watchout.presentation.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.danc.watchout.R
import com.danc.watchout.presentation.navigation.ScreenRoutes

@Composable
fun BottomAppBarComponent(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val screens = listOf(
        ScreenRoutes.Home,
        ScreenRoutes.Film,
        ScreenRoutes.Vehicle,
        ScreenRoutes.StarShip,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Row(
        modifier = modifier
            .height(40.dp)
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            SingleBottomAppItem(
                screenRoutes = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.SingleBottomAppItem(
    screenRoutes: ScreenRoutes,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screenRoutes.route } == true
    val background =
        if (selected) MaterialTheme.colors.onBackground else MaterialTheme.colors.background
    val contentColor =
        if (selected) MaterialTheme.colors.background else MaterialTheme.colors.onBackground

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(
                onClick = {
                    navController.navigate(screenRoutes.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = if (selected) screenRoutes.icon_focused else screenRoutes.icon),
                contentDescription = "icon",
                tint = contentColor,
                modifier = Modifier.padding(end = 15.dp)
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = screenRoutes.title,
                    style = TextStyle(
                        color = contentColor,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }

}
