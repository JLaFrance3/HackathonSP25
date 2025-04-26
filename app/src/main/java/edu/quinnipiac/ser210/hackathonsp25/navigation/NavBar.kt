package edu.quinnipiac.ser210.hackathonsp25.navigation

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.ui.unit.coerceIn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBar (
    navController: NavController,
    scope: CoroutineScope,
    drawerState: DrawerState,
    currentRoute: String?,
    modifier: Modifier = Modifier,
) {
    // Get context (for share button)
    val context = LocalContext.current

    // Change navbar text based on screen
    var navBarText = when (currentRoute?.substringBefore("/")) {
        Screens.HomeScreen.name -> "Home"
        Screens.JobScreen.name -> "Jobs"
        Screens.PetSuppliesScreen.name -> "Supplies"
        Screens.ProfileScreen.name -> "Profile"
        Screens.SavedJobsScreen.name -> "Saved"
        else -> "Change this text in NavBar.kt"
    }

    // Default to "Recipe" if recipe title cant be retrieved
    if(navBarText.isNullOrBlank()){
        navBarText = "Pawfessional"
    }

    Column { // (For a divider line at the bottom)
        CenterAlignedTopAppBar(
            title = {
                // Box to scale text
                Box {
                    Text(
                        text = navBarText,
                        color = MaterialTheme.colorScheme.onSecondary,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.W900,
                        textAlign = TextAlign.Center,
                    )
                }
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier
                            .size(32.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondary
            ),
            modifier = modifier
                .fillMaxWidth()
        )

        HorizontalDivider(
            color = MaterialTheme.colorScheme.tertiary,
            thickness = 3.dp
        )
    }
}