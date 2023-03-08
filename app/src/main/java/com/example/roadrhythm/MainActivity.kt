package com.example.roadrhythm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import com.example.roadrhythm.ui.theme.RoadRhythmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetsController?.isAppearanceLightNavigationBars = true

        val authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]

        setContent {
            RoadRhythmTheme() {
                RoadRhythm(authViewModel = authViewModel)
            }
        }
    }
}

@Composable
fun RoadRhythm(authViewModel: AuthViewModel) {
    val isLoggedIn = authViewModel.isLoggedIn.value

    if (isLoggedIn) {
        HomeActivity()
    } else {
        LogInActivity(authViewModel)
    }
}