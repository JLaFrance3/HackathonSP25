package edu.quinnipiac.ser210.hackathonsp25.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import edu.quinnipiac.ser210.rezippy.R

@Composable
fun DetailScreen(
    navController: NavController,
    cityName: String,
) {

}

@Composable
fun ProfileScreen() {
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    var resumeUri by remember { mutableStateOf<Uri?>(null) }

    // File picker launcher
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        resumeUri = uri // Save the selected file URI
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background image
        AsyncImage(
            model = R.drawable.cartoonbackground,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Foreground content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Semi-transparent background for content
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White.copy(alpha = 0.8f))
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "Profile Screen",
                        color = Color.Black,
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    BasicTextField(
                        value = name.value,
                        onValueChange = { name.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray.copy(alpha = 0.5f))
                            .padding(8.dp),
                        decorationBox = { innerTextField ->
                            if (name.value.isEmpty()) {
                                Text(text = "Enter your name", color = Color.Gray)
                            }
                            innerTextField()
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    BasicTextField(
                        value = email.value,
                        onValueChange = { email.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray.copy(alpha = 0.5f))
                            .padding(8.dp),
                        decorationBox = { innerTextField ->
                            if (email.value.isEmpty()) {
                                Text(text = "Enter your email", color = Color.Gray)
                            }
                            innerTextField()
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Button to upload resume
                    Button(onClick = { launcher.launch("application/pdf") }) {
                        Text(text = "Upload Resume")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Display selected resume file
                    resumeUri?.let {
                        Text(text = "Selected Resume: ${it.lastPathSegment}", color = Color.Black)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}