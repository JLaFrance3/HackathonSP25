package edu.quinnipiac.ser210.hackathonsp25.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.quinnipiac.ser210.hackathonsp25.R

// --- Data class for Supplies ---
data class PetSupply(
    val name: String,
    val imageRes: Int
)

// --- Pet Supplies Screen ---
@Composable
fun PetSuppliesScreen() {
    val petSupplies = listOf(
        PetSupply("Kibble", R.drawable.kibble),
        PetSupply("Ball", R.drawable.ball),
        PetSupply("Toy", R.drawable.toy),
        PetSupply("Water Bowl", R.drawable.water_bowl),
        PetSupply("Bone", R.drawable.bone),
        PetSupply("Dog Bowl", R.drawable.dog_bowl),
        PetSupply("Food Bowl", R.drawable.food_bowl),
        PetSupply("Rope", R.drawable.rope),
        PetSupply("Treats", R.drawable.treats)
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Pet Supplies",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(petSupplies) { supply ->
                SupplyItem(supply)
            }
        }
    }
}

@Composable
fun SupplyItem(supply: PetSupply) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = supply.imageRes),
                contentDescription = supply.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = supply.name,
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetSuppliesScreenPreview() {
    // Fake preview without actual image loading
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Pet Supplies (Preview)",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(5) { index ->
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .aspectRatio(1f)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Item $index",
                            style = MaterialTheme.typography.bodyMedium,
                            maxLines = 1
                        )
                    }
                }
            }
        }
    }
}
