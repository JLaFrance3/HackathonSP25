package edu.quinnipiac.ser210.hackathonsp25

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import edu.quinnipiac.ser210.hackathonsp25.ui.theme.HackathonSP25Theme

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
                Navigation(
                    recipeViewModel,
                    isDarkMode = isDarkMode,
                    onToggleTheme = { isDarkMode = !isDarkMode }
                )
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