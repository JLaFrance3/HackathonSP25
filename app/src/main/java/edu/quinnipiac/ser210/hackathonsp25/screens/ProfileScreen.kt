package edu.quinnipiac.ser210.hackathonsp25.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import edu.quinnipiac.ser210.hackathonsp25.R

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
    var profilePictureUri by remember { mutableStateOf<Uri?>(null) }

    // State for job experience
    val jobExperiences = remember { mutableStateListOf<Pair<String, String>>() }
    var newJobTitle by remember { mutableStateOf("") }
    var newCompanyName by remember { mutableStateOf("") }

    // State for education
    val educationList = remember { mutableStateListOf<Pair<String, String>>() }
    var newSchoolName by remember { mutableStateOf("") }
    var newDegree by remember { mutableStateOf("") }

    // State for skills
    val skillsList = remember { mutableStateListOf<String>() }
    var newSkill by remember { mutableStateOf("") }

    // File picker launcher for profile picture
    val profilePictureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        profilePictureUri = uri // Save the selected profile picture URI
    }

    // File picker launcher for resume
    val resumeLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        resumeUri = uri // Save the selected resume URI
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
                .padding(16.dp)
                .verticalScroll(rememberScrollState()), // Enable scrolling
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Picture
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .clickable { profilePictureLauncher.launch("image/*") },
                contentAlignment = Alignment.Center
            ) {
                if (profilePictureUri != null) {
                    AsyncImage(
                        model = profilePictureUri,
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Text(
                        text = "Upload Picture",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // White box around text fields and button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
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
                    Button(onClick = { resumeLauncher.launch("application/pdf") }) {
                        Text(text = "Upload Resume")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Display selected resume file
                    resumeUri?.let {
                        Text(text = "Selected Resume: ${it.lastPathSegment}", color = Color.Black)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Job Experience Section
                    Text(
                        text = "Previous Job Experience",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // List of job experiences
                    jobExperiences.forEach { (jobTitle, companyName) ->
                        Text(
                            text = "$jobTitle at $companyName",
                            color = Color.Black,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Input fields for new job experience
                    BasicTextField(
                        value = newJobTitle,
                        onValueChange = { newJobTitle = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray.copy(alpha = 0.5f))
                            .padding(8.dp),
                        decorationBox = { innerTextField ->
                            if (newJobTitle.isEmpty()) {
                                Text(text = "Enter job title", color = Color.Gray)
                            }
                            innerTextField()
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    BasicTextField(
                        value = newCompanyName,
                        onValueChange = { newCompanyName = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray.copy(alpha = 0.5f))
                            .padding(8.dp),
                        decorationBox = { innerTextField ->
                            if (newCompanyName.isEmpty()) {
                                Text(text = "Enter company name", color = Color.Gray)
                            }
                            innerTextField()
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            if (newJobTitle.isNotEmpty() && newCompanyName.isNotEmpty()) {
                                jobExperiences.add(newJobTitle to newCompanyName)
                                newJobTitle = ""
                                newCompanyName = ""
                            }
                        }
                    ) {
                        Text(text = "Add Job Experience")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Education Section
                    Text(
                        text = "Education",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // List of education entries
                    educationList.forEach { (schoolName, degree) ->
                        Text(
                            text = "$degree from $schoolName",
                            color = Color.Black,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Input fields for new education entry
                    BasicTextField(
                        value = newSchoolName,
                        onValueChange = { newSchoolName = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray.copy(alpha = 0.5f))
                            .padding(8.dp),
                        decorationBox = { innerTextField ->
                            if (newSchoolName.isEmpty()) {
                                Text(text = "Enter school name", color = Color.Gray)
                            }
                            innerTextField()
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    BasicTextField(
                        value = newDegree,
                        onValueChange = { newDegree = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray.copy(alpha = 0.5f))
                            .padding(8.dp),
                        decorationBox = { innerTextField ->
                            if (newDegree.isEmpty()) {
                                Text(text = "Enter degree", color = Color.Gray)
                            }
                            innerTextField()
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            if (newSchoolName.isNotEmpty() && newDegree.isNotEmpty()) {
                                educationList.add(newSchoolName to newDegree)
                                newSchoolName = ""
                                newDegree = ""
                            }
                        }
                    ) {
                        Text(text = "Add Education")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Skills Section
                    Text(
                        text = "Skills",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // List of skills
                    skillsList.forEach { skill ->
                        Text(
                            text = skill,
                            color = Color.Black,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Input field for new skill
                    BasicTextField(
                        value = newSkill,
                        onValueChange = { newSkill = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray.copy(alpha = 0.5f))
                            .padding(8.dp),
                        decorationBox = { innerTextField ->
                            if (newSkill.isEmpty()) {
                                Text(text = "Enter a skill", color = Color.Gray)
                            }
                            innerTextField()
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            if (newSkill.isNotEmpty()) {
                                skillsList.add(newSkill)
                                newSkill = ""
                            }
                        }
                    ) {
                        Text(text = "Add Skill")
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