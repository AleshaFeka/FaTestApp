package com.example.fanaticstestapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.fanaticstestapp.ui.theme.FanBackgroundGradientBottomColor
import com.example.fanaticstestapp.ui.theme.FanBackgroundGradientTopColor
import com.example.fanaticstestapp.ui.theme.FanaticsTestAppTheme

@Composable
fun FanScreenWrapper(
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean = false,
    onNavigateBack: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        FanBackgroundGradientTopColor,
                        FanBackgroundGradientBottomColor,
                    )
                )
            ),
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                FanAppBar(
                    canNavigateBack = canNavigateBack,
                    navigateBack = onNavigateBack
                )
            },
        ) { paddingValues ->
            Box(modifier = modifier.padding(paddingValues)) {
                content()
            }
        }
    }
}

@Preview
@Composable
fun FanHomeScreenPreview() {
    FanaticsTestAppTheme {
        FanScreenWrapper {
            Text(text = "Content")
        }
    }
}