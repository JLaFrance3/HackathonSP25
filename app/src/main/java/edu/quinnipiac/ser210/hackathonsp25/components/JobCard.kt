package edu.quinnipiac.ser210.hackathonsp25.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import edu.quinnipiac.ser210.hackathonsp25.R
import edu.quinnipiac.ser210.hackathonsp25.ui.theme.AppTheme

@Composable
fun JobCard(
    jobTitle: String,
    company: String,
    logo: Int
){
    Card(
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(4.dp, MaterialTheme.colorScheme.onPrimary),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .clip(RoundedCornerShape(28.dp))
    ){
        // For opening external URLs
        val uriHandler = LocalUriHandler.current

        Column(
            modifier = Modifier
                .padding(23.dp)
        ){
            // Information Section (Top)
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
            ){
                // Title
                Text(
                    text = jobTitle,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ){
                    // Logo
                    Image(
                        painter = painterResource(logo),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(64.dp) // or whatever size looks good
                    )
                    // Company
                    Text(
                        text = company,
                        fontSize = 22.sp,
                        maxLines = 1
                    )
                }

            }
            // Buttons Section (Bottom)
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            ){
                // Apply
                Button(
                    onClick = { uriHandler.openUri("https://www.youtube.com/watch?v=GBIIQ0kP15E") },
                    content = {
                        Text("Apply")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        contentColor = MaterialTheme.colorScheme.onTertiary
                    )
                )
                // Research
                Button(
                    onClick = { uriHandler.openUri("https://www.youtube.com/@MrBeast") },
                    content = {
                        Text("Research")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        contentColor = MaterialTheme.colorScheme.onTertiary
                    )
                )
                // Save
                Button(
                    onClick = { uriHandler.openUri("https://www.youtube.com") },
                    content = {
                        Icon(painterResource(R.drawable.bookmark), contentDescription = null)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        contentColor = MaterialTheme.colorScheme.onTertiary
                    )
                )
            }
        }
    }
}


@Preview
@Composable
fun Preview(){
    AppTheme {
        JobCard("Engineer", "Google", R.drawable.samplelogo)
    }
}

