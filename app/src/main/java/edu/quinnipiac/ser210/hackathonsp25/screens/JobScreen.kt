package edu.quinnipiac.ser210.hackathonsp25.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.quinnipiac.ser210.hackathonsp25.components.JobCard
import edu.quinnipiac.ser210.rezippy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobScreen() {
    // State for search query
    var searchQuery by remember { mutableStateOf("") }

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Search bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search Jobs") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.secondary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                    focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                    unfocusedTextColor = MaterialTheme.colorScheme.onSecondary,
                    cursorColor = MaterialTheme.colorScheme.tertiary
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Job Recommendations Section
            JobRecommendationsSection()

            Spacer(modifier = Modifier.height(16.dp))

            // Job Listings
            JobListings()
        }
    }
}

@Composable
fun JobRecommendationsSection() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Job Recommendations",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Based on your profile and experience with animals",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.8f)
            )
        }
    }
}

@Composable
fun JobListings() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            JobCard("Veterinary Assistant", "PetCare Clinic", painterResource(R.drawable.samplelogo))
        }
        item {
            JobCard("Dog Walker", "Happy Tails Agency", painterResource(R.drawable.samplelogo))
        }
        item {
            JobCard("Pet Groomer", "Furry Friends Salon", painterResource(R.drawable.samplelogo))
        }
        item {
            JobCard("Animal Trainer", "Pawfect Training", painterResource(R.drawable.samplelogo))
        }
        item {
            JobCard("Pet Store Associate", "PetSmart", painterResource(R.drawable.samplelogo))
        }
        item {
            JobCard("Kennel Assistant", "Cozy Pet Hotel", painterResource(R.drawable.samplelogo))
        }
        item {
            JobCard("Veterinary Receptionist", "Animal Care Hospital", painterResource(R.drawable.samplelogo))
        }
        item {
            JobCard("Pet Nutritionist", "Healthy Pets Inc.", painterResource(R.drawable.samplelogo))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JobScreenPreview() {
    JobScreen()
}