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
}

@Preview
@Composable
fun Preview(){
    AppTheme() {
        SavedJobsScreen()
    }
}