package edu.quinnipiac.ser210.hackathonsp25.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage

@Composable
fun HomeScreen(
    navController: NavController,
    weatherViewModel: WeatherViewModel,
    backgroundColor: Color
) {
    val weatherResults = weatherViewModel.weatherResult.observeAsState()

    //Convert mapped <String, responses> to a map of <String, Arraylist>
    val weatherData = weatherResults.value?.filterValues { it.body() != null}?.mapValues { it.value.body()!! }

    Log.d("HomeScreen", "Initializing MainContent")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ){
        MainContent(navController = navController, weatherData)
    }
}

@Composable
fun MainContent (
    navController: NavController,
    weatherData: Map<String, WeatherData>?
) {
    WeatherColumn(
        navController = navController,
        weatherData = weatherData,
        modifier = Modifier.padding(8.dp)
    )
}

//Column of cards displaying weather information for various locations
@Composable
fun WeatherColumn(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn {

    }
}
