package edu.quinnipiac.ser210.hackathonsp25.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import edu.quinnipiac.ser210.rezippy.R

@Composable
fun JobCard(
    jobTitle: String,
    company: String,
    logo: Painter
){
    Card(
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(4.dp, MaterialTheme.colorScheme.tertiary),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .clip(RoundedCornerShape(28.dp))
    ){
        // For opening external URLs
        val uriHandler = LocalUriHandler.current

        Column(){
            // Information Section (Top)
            Column(){
                Text(jobTitle)
                Row(){
                    // Logo
                    AsyncImage(
                        model = R.drawable.samplelogo,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    // Company
                    Text(company)
                }

            }
            // Buttons Section (Bottom)
            Row(){
                // Apply
                Button(
                    onClick = { uriHandler.openUri("https://www.youtube.com/watch?v=GBIIQ0kP15E") },
                    content = {
                        Text("Apply")
                    }
                )
                // Research
                Button(
                    onClick = { uriHandler.openUri("https://www.youtube.com/@MrBeast") },
                    content = {
                        Text("Research")
                    }
                )
                // Save
                Button(
                    onClick = { uriHandler.openUri("https://www.youtube.com") },
                    content = {
                        Icon(painterResource(R.drawable.bookmark), contentDescription = null)
                    }
                )
            }
        }
    }
}


@Preview
@Composable
fun Preview(){
    JobCard("Engineer", "Epic company", painterResource(R.drawable.samplelogo))
}

