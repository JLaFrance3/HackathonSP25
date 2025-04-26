package edu.quinnipiac.ser210.hackathonsp25.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.hackathonsp25.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavDrawer(
    navController: NavController,
    drawerState: DrawerState,
    scope: CoroutineScope,
    selectedScreen: MutableState<String>,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet (
                drawerContainerColor = MaterialTheme.colorScheme.primary,
            ) {
                Column (
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(horizontal = 16.dp)
                        .background(MaterialTheme.colorScheme.primary)
                        .verticalScroll(rememberScrollState())
                ) {
                    //Drawer title
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = "Pawfessional",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                    //Profile option
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Profile",
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.AccountCircle,
                                contentDescription = null
                            )
                        },
                        selected = selectedScreen.value == Screens.ProfileScreen.name,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                                selectedScreen.value = Screens.ProfileScreen.name
                                navController.navigate(Screens.ProfileScreen.name)
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = MaterialTheme.colorScheme.secondary,
                            selectedContainerColor = MaterialTheme.colorScheme.tertiary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                            selectedTextColor = MaterialTheme.colorScheme.onSecondary
                        )
                    )
                    HorizontalDivider()

                    Text(
                        text = "Pet",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                    //Home option
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Home",
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = null
                            )
                        },
                        selected = selectedScreen.value == Screens.HomeScreen.name,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                                selectedScreen.value = Screens.HomeScreen.name
                                navController.navigate(Screens.HomeScreen.name)
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = MaterialTheme.colorScheme.secondary,
                            selectedContainerColor = MaterialTheme.colorScheme.tertiary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                            selectedTextColor = MaterialTheme.colorScheme.onSecondary
                        )
                    )
                    //Pet stuff option
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Pet Supplies",
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.paw),
                                contentDescription = null
                            )
                        },
                        selected = selectedScreen.value == Screens.PetSuppliesScreen.name,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                                selectedScreen.value = Screens.PetSuppliesScreen.name
                                navController.navigate(Screens.PetSuppliesScreen.name)
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = MaterialTheme.colorScheme.secondary,
                            selectedContainerColor = MaterialTheme.colorScheme.tertiary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                            selectedTextColor = MaterialTheme.colorScheme.onSecondary
                        )
                    )
                    HorizontalDivider()

                    // Jobs section
                    Text(
                        text = "Job",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                    // Jobs option
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Jobs",
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Outlined.Info,
                                contentDescription = null
                            )
                        },
                        selected = false,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                                selectedScreen.value = Screens.JobScreen.name
                                navController.navigate(Screens.JobScreen.name)
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = MaterialTheme.colorScheme.secondary,
                            selectedContainerColor = MaterialTheme.colorScheme.tertiary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                            selectedTextColor = MaterialTheme.colorScheme.onSecondary
                        )
                    )
                    // Saved Jobs option
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Saved Jobs",
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.bookmark),
                                contentDescription = null
                            )
                        },
                        selected = selectedScreen.value == Screens.SavedJobsScreen.name,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                                selectedScreen.value = Screens.SavedJobsScreen.name
                                navController.navigate(Screens.SavedJobsScreen.name)
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = MaterialTheme.colorScheme.secondary,
                            selectedContainerColor = MaterialTheme.colorScheme.tertiary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                            selectedTextColor = MaterialTheme.colorScheme.onSecondary
                        )
                    )

                    // Settings section
                    Text(
                        text = "Settings",
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                    // Settings option
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Settings",
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Outlined.Settings,
                                contentDescription = null
                            )
                        },
                        selected = selectedScreen.value == "SettingsScreen",    //Doesn't exist
                        onClick = {
                            scope.launch {
                                //Nothin
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = MaterialTheme.colorScheme.secondary,
                            selectedContainerColor = MaterialTheme.colorScheme.tertiary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                            selectedTextColor = MaterialTheme.colorScheme.onSecondary
                        )
                    )
                    //Help option
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Help",
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        selected = selectedScreen.value == "Help Screen",    //Doesn't exist
                        icon = {
                            Icon(
                                imageVector = Icons.Outlined.Info,
                                contentDescription = null
                            )
                        },
                        onClick = {
                            scope.launch {
                                //Nothin
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = MaterialTheme.colorScheme.secondary,
                            selectedContainerColor = MaterialTheme.colorScheme.tertiary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                            selectedTextColor = MaterialTheme.colorScheme.onSecondary
                        )
                    )
                    Spacer(Modifier.height(12.dp))
                }
            }
        },
        drawerState = drawerState,
        content = content
    )
}