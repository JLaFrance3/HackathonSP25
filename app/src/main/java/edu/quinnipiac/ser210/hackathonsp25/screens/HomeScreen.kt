package edu.quinnipiac.ser210.hackathonsp25.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import edu.quinnipiac.ser210.rezippy.R

@Composable
fun HomeScreen(
) {
    val level: Int = 1
    val xp: Int = 45
    val maxXp: Int = 200
    val name: String = "Jimmy"

    Column(){
        AsyncImage(
            model = R.drawable.cartoonbackground,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(){
            // Name
            Text(
                text = name,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )
            // Level
            Text(
                text = "Level $level",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            // XP
            Text(
                text = "XP: $xp / $maxXp",
                fontSize = 18.sp
            )
        }
    }
}