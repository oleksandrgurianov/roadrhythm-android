package com.example.roadrhythm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import com.example.roadrhythm.ui.theme.RoadRhythmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        val gestureControl = GestureControl(this)

        setContent {
            RoadRhythmTheme {
                RoadRhythm(authViewModel = authViewModel, gestureControl = gestureControl)
            }
        }
    }
}

@Composable
fun RoadRhythm(authViewModel: AuthViewModel, gestureControl: GestureControl) {
    val isLoggedIn = authViewModel.isLoggedIn.value


    if (isLoggedIn) {
        HomeActivity(authViewModel, gestureControl)
    } else {
        LogInActivity(authViewModel)
    }
}