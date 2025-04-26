package edu.quinnipiac.ser210.hackathonsp25.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.quinnipiac.ser210.hackathonsp25.components.JobCard
import edu.quinnipiac.ser210.hackathonsp25.R

@Composable
fun SavedJobsScreen(){
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            item{
                JobCard("Software Engineer", "Google", painterResource(R.drawable.samplelogo))
            }
            item{
                JobCard("iOS Developer", "Apple", painterResource(R.drawable.samplelogo))
            }
            item{
                JobCard("Operations Manager", "Amazon", painterResource(R.drawable.samplelogo))
            }
            item{
                JobCard("Cloud Solutions Architect", "Microsoft", painterResource(R.drawable.samplelogo))
            }
            item{
                JobCard("Data Scientist", "Meta", painterResource(R.drawable.samplelogo))
            }
            item{
                JobCard("Manufacturing Engineer", "Tesla", painterResource(R.drawable.samplelogo))

            }
            item{
                JobCard("Content Strategist", "Netflix", painterResource(R.drawable.samplelogo))
            }
            item{
                JobCard("Marketing Coordinator", "Disney", painterResource(R.drawable.samplelogo))
            }
        }
    }
}

@Preview
@Composable
fun Preview(){
    SavedJobsScreen()
}