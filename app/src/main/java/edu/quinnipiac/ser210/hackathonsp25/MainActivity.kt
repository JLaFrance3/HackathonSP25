package edu.quinnipiac.ser210.hackathonsp25

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import edu.quinnipiac.ser210.hackathonsp25.ui.theme.AppTheme
import edu.quinnipiac.ser210.hackathonsp25.navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkMode by remember { mutableStateOf(false) }
            HackathonSP25Theme(
                useDarkTheme = isDarkMode,
                onToggleTheme = { isDarkMode = !isDarkMode }
            ) {
                Navigation()
            }
        }
    }
}

@Composable
fun HackathonSP25Theme(
    useDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    content: @Composable () -> Unit
) {
    AppTheme(darkTheme = useDarkTheme) {
        content()
    }
}