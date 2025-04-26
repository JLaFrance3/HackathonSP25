package edu.quinnipiac.ser210.hackathonsp25.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.quinnipiac.ser210.hackathonsp25.screens.DetailScreen
import edu.quinnipiac.ser210.hackathonsp25.screens.HomeScreen

@Composable
fun Navigation(

){
    // NavController
    val navController = rememberNavController()

    Scaffold (

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(Screens.HomeScreen.name) {
                HomeScreen()
            }
            composable(
                Screens.DetailScreen.name+"/{name}",
                arguments = listOf(navArgument(name = "name") {type = NavType.StringType})
            ) {

                DetailScreen(

                )
            }
        }
    }
}