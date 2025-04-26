package edu.quinnipiac.ser210.hackathonsp25.screens

import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// --- Data class for Supplies ---
data class PetSupply(
    val name: String,
    val x: Int,
    val y: Int,
    val width: Int,
    val height: Int
)

// --- Sample Data ---
val petSupplies = listOf(
    PetSupply("Kibble", 300, 0, 900, 1100),
    PetSupply("Water Bowl", 1200, 0, 1050, 1100),
    PetSupply("Food Bowl", 2250, 0, 900, 1100),
    PetSupply("Ball", 350, 1230, 560, 580),
    PetSupply("Tennis Ball", 940, 1200, 300, 300),
    PetSupply("Toy", 1955, 1085, 700, 760),
    PetSupply("Rope", 2670, 1100, 800, 725),
    PetSupply("Treats", 1415, 1953, 675, 775),
    PetSupply("Paw Bowl", 345, 2075, 800, 615)
)

// --- Pet Supplies Screen ---
@Composable
fun PetSuppliesScreen() {
    val context = LocalContext.current
    val fullBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.foodsupply)

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
                SupplyItem(supply, fullBitmap)
            }
        }
    }
}

@Composable
fun SupplyItem(supply: PetSupply, fullBitmap: Bitmap) {
    val itemBitmap = Bitmap.createBitmap(
        fullBitmap,
        supply.x,
        supply.y,
        supply.width,
        supply.height
    )

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
                bitmap = itemBitmap.asImageBitmap(),
                contentDescription = supply.name,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = supply.name, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetSuppliesScreenPreview() {
    // Fake preview without actual bitmap loading
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
            items(petSupplies) { supply ->
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
                                .size(64.dp)
                                .padding(8.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = supply.name, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
