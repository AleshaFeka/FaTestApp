package com.example.fanaticstestapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fanaticstestapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FanAppBar(
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit = {},
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.people),
                style = if (canNavigateBack) MaterialTheme.typography.headlineSmall
                else MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(
                    start = if (canNavigateBack) 0.dp
                    else 4.dp
                ),
            )
        },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateBack) {
                    Icon(
                        modifier = Modifier.padding(top = 4.dp),
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
            }
        },
    )
}

@Preview
@Composable
fun PrCanNavigateBack() {
    FanAppBar(canNavigateBack = true)
}

@Preview
@Composable
fun PrCanNotNavigateBack() {
    FanAppBar(canNavigateBack = false)
}