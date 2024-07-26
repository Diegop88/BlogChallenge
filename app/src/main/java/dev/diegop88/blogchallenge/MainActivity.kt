package dev.diegop88.blogchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.diegop88.blogchallenge.ui.home.HomeScreen
import dev.diegop88.blogchallenge.ui.postMessage.PostMessage
import dev.diegop88.blogchallenge.ui.theme.BlogChallengeTheme
import dev.diegop88.blogchallenge.utils.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    val navController = rememberNavController()
    BlogChallengeTheme {
        NavHost(navController = navController, startDestination = Navigation.HOME) {
            composable(Navigation.HOME) {
                HomeScreen(navController)
            }
            composable(Navigation.NEW_MESSAGE) {
                PostMessage(navController)
            }
        }
    }
}
