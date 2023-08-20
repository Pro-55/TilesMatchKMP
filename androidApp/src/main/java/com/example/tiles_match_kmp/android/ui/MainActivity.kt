package com.example.tiles_match_kmp.android.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.tiles_match_kmp.android.framework.Screen
import com.example.tiles_match_kmp.android.theme.TilesMatchKmpTheme
import com.example.tiles_match_kmp.android.ui.options.OptionsScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // Global
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TilesMatchKmpTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Screen.OptionsScreen.route
                    ) {
                        composable(route = Screen.OptionsScreen.route,
                            exitTransition = {
                                slideOutHorizontally(
                                    targetOffsetX = { -it },
                                    animationSpec = tween(
                                        durationMillis = 400,
                                        easing = FastOutSlowInEasing
                                    )
                                )
                            },
                            popEnterTransition = {
                                slideInHorizontally(
                                    initialOffsetX = { -it },
                                    animationSpec = tween(
                                        durationMillis = 400,
                                        easing = FastOutSlowInEasing
                                    )
                                )
                            }
                        ) {
                            OptionsScreen(onClick = { option ->
                                Log.d(TAG, "TestLog: $option clicked")
                            })
                        }
                    }
                }
            }
        }
    }
}