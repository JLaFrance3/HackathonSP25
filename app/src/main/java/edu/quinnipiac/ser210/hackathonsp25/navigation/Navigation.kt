package edu.quinnipiac.ser210.hackathonsp25.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.quinnipiac.ser210.hackathonsp25.screens.DetailScreen
import edu.quinnipiac.ser210.hackathonsp25.screens.HomeScreen
import edu.quinnipiac.ser210.hackathonsp25.screens.JobScreen
import edu.quinnipiac.ser210.hackathonsp25.screens.PetSuppliesScreen
import edu.quinnipiac.ser210.hackathonsp25.screens.ProfileScreen
import edu.quinnipiac.ser210.hackathonsp25.screens.SavedJobsScreen

@Composable
fun Navigation(){
    // Navigation Drawer
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val selectedScreen = remember { mutableStateOf(Screens.HomeScreen.name) }
    val scope = rememberCoroutineScope()

    // NavController
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    NavDrawer(
        navController = navController,
        drawerState = drawerState,
        scope = scope,
        selectedScreen = selectedScreen
    ) {
        Scaffold (
            topBar = {
                NavBar(
                    navController = navController,
                    scope = scope,
                    drawerState = drawerState,
                    currentRoute = currentRoute
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screens.HomeScreen.name,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                composable(Screens.HomeScreen.name) {
                    HomeScreen()
                }
                composable(Screens.JobScreen.name) {
                    JobScreen()
                }
                composable(Screens.PetSuppliesScreen.name) {
                    PetSuppliesScreen()
                }
                composable(Screens.ProfileScreen.name) {
                    ProfileScreen()
                }
                composable(Screens.SavedJobsScreen.name) {
                    SavedJobsScreen()
                }
            }
        }
    }
}