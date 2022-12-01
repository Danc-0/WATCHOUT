package com.danc.watchout.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danc.watchout.domain.models.Peoples
import com.danc.watchout.domain.models.PeoplesResult

@Composable
fun SinglePersonComponent(
    person: PeoplesResult,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(5.dp)
            .border(
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.onSurface),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Column(modifier = modifier.padding(10.dp)){
            Text(
                text = person.name.uppercase(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )

            Row(
                modifier.fillMaxSize()
            ) {
                Text(
                    text = "DOB:",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(end = 5.dp)
                )

                Text(
                    text = person.dateOfBirth,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                )
            }

            Row(
                modifier.fillMaxSize()
            ) {
                Text(
                    text = "Gender:",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(end = 5.dp)
                )

                Text(
                    text = person.gender.uppercase(),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                )
            }

            Row(
                modifier.fillMaxSize()
            ) {
                Text(
                    text = "No. of Films:",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(end = 5.dp)
                )

                val totalFilms = person.films.size.toString()

                Text(
                    text = totalFilms,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                )
            }
        }
    }
}