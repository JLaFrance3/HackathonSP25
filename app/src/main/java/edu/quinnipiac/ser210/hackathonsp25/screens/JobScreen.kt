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
import edu.quinnipiac.ser210.hackathonsp25.R

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
                label = { Text(
                    text = "Search Jobs",
                    color = MaterialTheme.colorScheme.outlineVariant
                    ) },
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
        item{
            JobCard("Software Engineer", "Travelers", (R.drawable.travellers), "https://www.indeed.com/jobs?q=travelers+insurance&l=Hamden%2C+CT&radius=25&from=searchOnDesktopSerp%2Cwhatautocomplete&cf-turnstile-response=0.voKkdExfx1H4Mjbt7bPD1hfN-MO8FkpDdee40snS0psT9q8xJSVHgyqzbUGp_nr0ocnIXvFWUP8gPkj69iRs21mBwKnzWEATLNrDQNeIPaARNQ1fjDV9K7ntcI1c5cve6HQmrMNbccjfTQLSruG1t22JT6DQgEXuze-XJV8g5Ws6PaWA1hX9Kba3_lw81aFvv30rsIWZYZdK6hyK1x5i95Auxs2NetAJgaU4yjJOffADR0zlULIDtrwW4_1JWSsEBtzNQS0QvqLux3cAtg95r2P0z9KbbO6IZFwdUYiVQdNmGI9tofRw2EZPhtu0rqH1UPKU2ZPXKFe2j4rtSppoErXCm5lJra18WSnbsSFelUPDoR2_SdRT3pTgPwQJWekccjObOL56s6OId7to2Tv1shAudHUGj9PANGpP4_8uLMFEW2fMVEmqjHT6Z9bhA3iJNEArbIPgaOLEOJOiaeDtPoAtmojBvWQNK9vyssDo7A5y3XjQdW5IGaYmViToEe8d64HUhzt06m6Yas5uHRU3oVGhS4KDgj2wx410Nt0yw3oYZcFKsEnwcxH9KYW7Coas45qkrAh-uOeZOGBe0q7mwZZJDsCBNGlCJTdeo8UrVirlqK363YRiGb0GCGVCmDrVW9ZCZDruOntmZ7Rd9hLzvdbIqWtbcfOm7DZI3WgJiufN25feRgWjfMgdyTAzGQmTYd2jQsZJ9Pcb4wAD5kwkwJgh-BJwb0mUv01_55ed2x-7xWor4f8_dHg5RbFH7XvWRXtSZQ1EwDqe9FA9B4mNbrA8mXhoxUyvV-fWBbZ9PhBOySRskwUgSbn85F1_zj-t.acrO9cwt3ve3z7JAKbYNnQ.5f1869ea2ba5b88e0981dfbde359d55a62385d3982f093703a1774a77e596a61&vjk=48c18eb953fa86e9")
        }
        item{
            JobCard("iOS Developer", "Travelers", (R.drawable.travellers), "https://www.indeed.com/jobs?q=travelers+insurance&l=Hamden%2C+CT&radius=25&from=searchOnDesktopSerp%2Cwhatautocomplete&cf-turnstile-response=0.voKkdExfx1H4Mjbt7bPD1hfN-MO8FkpDdee40snS0psT9q8xJSVHgyqzbUGp_nr0ocnIXvFWUP8gPkj69iRs21mBwKnzWEATLNrDQNeIPaARNQ1fjDV9K7ntcI1c5cve6HQmrMNbccjfTQLSruG1t22JT6DQgEXuze-XJV8g5Ws6PaWA1hX9Kba3_lw81aFvv30rsIWZYZdK6hyK1x5i95Auxs2NetAJgaU4yjJOffADR0zlULIDtrwW4_1JWSsEBtzNQS0QvqLux3cAtg95r2P0z9KbbO6IZFwdUYiVQdNmGI9tofRw2EZPhtu0rqH1UPKU2ZPXKFe2j4rtSppoErXCm5lJra18WSnbsSFelUPDoR2_SdRT3pTgPwQJWekccjObOL56s6OId7to2Tv1shAudHUGj9PANGpP4_8uLMFEW2fMVEmqjHT6Z9bhA3iJNEArbIPgaOLEOJOiaeDtPoAtmojBvWQNK9vyssDo7A5y3XjQdW5IGaYmViToEe8d64HUhzt06m6Yas5uHRU3oVGhS4KDgj2wx410Nt0yw3oYZcFKsEnwcxH9KYW7Coas45qkrAh-uOeZOGBe0q7mwZZJDsCBNGlCJTdeo8UrVirlqK363YRiGb0GCGVCmDrVW9ZCZDruOntmZ7Rd9hLzvdbIqWtbcfOm7DZI3WgJiufN25feRgWjfMgdyTAzGQmTYd2jQsZJ9Pcb4wAD5kwkwJgh-BJwb0mUv01_55ed2x-7xWor4f8_dHg5RbFH7XvWRXtSZQ1EwDqe9FA9B4mNbrA8mXhoxUyvV-fWBbZ9PhBOySRskwUgSbn85F1_zj-t.acrO9cwt3ve3z7JAKbYNnQ.5f1869ea2ba5b88e0981dfbde359d55a62385d3982f093703a1774a77e596a61&vjk=48c18eb953fa86e9")
        }
        item{
            JobCard("Operations Manager", "M&T Bank", (R.drawable.mnt), "https://www.indeed.com/cmp/M&T-Bank?from=mobviewjob&tk=1ippjqt01ia5j801&fromjk=0e688b2de9cae27d&attributionid=mobvjcmp")
        }
        item{
            JobCard("Cloud Solutions Architect", "UNAPEN", (R.drawable.unapen), "https://unapen.com/")
        }
        item{
            JobCard("Data Scientist", "M&T Bank", (R.drawable.mnt), "https://www.indeed.com/cmp/M&T-Bank?from=mobviewjob&tk=1ippjqt01ia5j801&fromjk=0e688b2de9cae27d&attributionid=mobvjcmp")
        }
        item {
            JobCard("Pet Nutritionist", "Healthy Pets Inc.", (R.drawable.samplelogo), "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JobScreenPreview() {
    JobScreen()
}