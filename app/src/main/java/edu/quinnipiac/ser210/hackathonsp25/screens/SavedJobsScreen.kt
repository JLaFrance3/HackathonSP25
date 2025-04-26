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
import edu.quinnipiac.ser210.hackathonsp25.ui.theme.AppTheme

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
                JobCard("Software Engineer", "Travelers", (R.drawable.travellers))
            }
            item{
                JobCard("iOS Developer", "Travelers", (R.drawable.travellers))
            }
            item{
                JobCard("Operations Manager", "M&T Bank", (R.drawable.mnt))
            }
            item{
                JobCard("Cloud Solutions Architect", "UNAPEN", (R.drawable.unapen))
            }
            item{
                JobCard("Data Scientist", "M&T Bank", (R.drawable.mnt))
            }
            item{
                JobCard("Manufacturing Engineer", "Tesla", (R.drawable.samplelogo))

            }
            item{
                JobCard("Content Strategist", "Netflix", (R.drawable.samplelogo))
            }
            item{
                JobCard("Marketing Coordinator", "Disney", (R.drawable.samplelogo))
            }
        }
    }
}

@Preview
@Composable
fun Preview(){
    AppTheme() {
        SavedJobsScreen()
    }
}