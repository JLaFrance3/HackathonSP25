package edu.quinnipiac.ser210.hackathonsp25.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import edu.quinnipiac.ser210.hackathonsp25.ui.theme.AppTheme
import edu.quinnipiac.ser210.hackathonsp25.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.IntOffset
import coil3.compose.AsyncImagePainter.State.Empty.painter
import com.airbnb.lottie.L
import kotlin.math.roundToInt

@Composable
fun HomeScreen(
) {
    val level: Int = 1
    val xp: Int = 45
    val maxXp: Int = 200
    val name: String = "Jimmy"

    Column(){
        PetDisplay()
        PetInfo(name, level, xp, maxXp)
        QuestSection()
    }
}

@Composable
fun QuestSection(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(20.dp)
    ){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)

        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                Text(
                    text = "Quests",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Quests()
            }
        }
    }
}

@Composable
fun Quests(){
    Quest("Weekly", "Apply to a job!")
    Quest("Weekly", "Save 5 companies")
    Quest("Daily", "Interview prep: Research a saved company")
}

@Composable
fun Quest(type: String, desc: String){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(
            type,
            fontSize = 18.sp,
            fontWeight = Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(desc)
    }
}

@Composable
fun PetDisplay(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
//            .height(480.dp)
    ){
        AsyncImage(
            model = R.drawable.cartoonbackground,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        SpriteAnimation()
    }
}

@Composable
fun PetInfo(name: String, level: Int, xp: Int, maxXp: Int){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(12.dp)
    ) {
        // Name
        Text(
            text = name,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary
        )
        // Level
        Text(
            text = "Level $level",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary
        )
        // XP
        Text(
            text = "XP: $xp / $maxXp",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }

}

@Composable
fun SpriteAnimation() {
    val walkingRightFrames = listOf(
        R.drawable.walk1,
        R.drawable.walk2,
        R.drawable.walk3,
        R.drawable.walk4
    )

    val walkingLeftFrames = listOf(
        R.drawable.walkl1,
        R.drawable.walkl2,
        R.drawable.walkl3,
        R.drawable.walkl4
    )

    val idleFrames = listOf(
        R.drawable.t1,
        R.drawable.t2,
        R.drawable.t3,
        R.drawable.t3
    )

    var currentFrame by remember { mutableIntStateOf(0) }
    val xOffset = remember { Animatable(0f) }
    var movingRight by remember { mutableStateOf(true) }
    var idle by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(100L)
            currentFrame = (currentFrame + 1) % 4
        }
    }

    // Move left and right infinitely
    LaunchedEffect(Unit) {
        while (true) {
            // Move right
            movingRight = true
            idle = false
            xOffset.animateTo(
                targetValue = 350f,
                animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
            )
            // Move left
            movingRight = false
            xOffset.animateTo(
                targetValue = -350f,
                animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
            )
            // Idle
            idle = true
            xOffset.snapTo(-350f) // <- instantly jump to center, no smooth animation
            delay(4000L)
        }
    }

    val framesToUse: List<Int> = if(idle){
        idleFrames
    } else if(movingRight){
        walkingRightFrames
    } else {
        walkingLeftFrames
    }

    Box(
        contentAlignment = Alignment.Center, // centers contents inside Box
        modifier = Modifier
            .fillMaxWidth()
    ){
        if (idle) {
            // Text bubble shown only when idling
            Text(
                text = "Woof 🐶 Its a good day to get a job!",
                modifier = Modifier
                    .align(Alignment.TopCenter) // <--- THIS centers it horizontally
                    .offset(y = 200.dp, x = -50.dp)           // move it DOWN a little from the top
                    .background(
                        MaterialTheme.colorScheme.primary,
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(8.dp),
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 16.sp
            )
        }

        Image(
            painter = painterResource(id = framesToUse[currentFrame]),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .offset { IntOffset((xOffset.value + 0f).roundToInt(), 750) }
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    AppTheme(){
        HomeScreen()
    }
}
