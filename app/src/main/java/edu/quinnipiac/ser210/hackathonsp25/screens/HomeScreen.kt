package edu.quinnipiac.ser210.hackathonsp25.screens

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
import com.example.compose.AppTheme
import edu.quinnipiac.ser210.rezippy.R

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
            .height(480.dp)
    ){
        AsyncImage(
            model = R.drawable.cartoonbackground,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
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

@Preview
@Composable
fun HomeScreenPreview(){
    AppTheme(){
        HomeScreen()
    }
}


@Preview
@Composable
fun QuestsPreview(){
    Quests()
}

