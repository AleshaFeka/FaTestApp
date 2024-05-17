package com.example.fanaticstestapp

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.fanaticstestapp.navigation.FanNavHost
import com.example.fanaticstestapp.ui.screens.home.FanHomeScreen
import com.example.fanaticstestapp.ui.components.FanCharactersList
import com.example.fanaticstestapp.ui.theme.FanaticsTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableFullScreen()

        setContent {
            FanaticsTestAppTheme {
                FanNavHost()
            }
        }
    }

    private fun enableFullScreen() {
        actionBar?.hide()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        } else {
            window.insetsController?.apply {
                hide(WindowInsets.Type.statusBars())
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
    }
}

