package com.example.fanaticstestapp.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fanaticstestapp.ui.components.FanCharactersList
import com.example.fanaticstestapp.ui.theme.FanaticsTestAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fanaticstestapp.ui.components.FanScreenWrapper
import com.example.fanaticstestapp.ui.models.CharacterUiModel
import com.example.fanaticstestapp.ui.theme.FanWhite

@Composable
fun FanHomeScreen(
    onNavigateToDetails: (CharacterUiModel) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: FanHomeScreenViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    FanScreenWrapper(
        modifier = modifier,
    ) {
        if (uiState.isLoading) Loading(modifier)
        else Content(uiState, onNavigateToDetails)
    }
}

@Composable
private fun Content(
    uiState: FanHomeScreenUiState,
    onNavigateToDetails: (CharacterUiModel) -> Unit,
    modifier: Modifier = Modifier
) {
    FanCharactersList(
        modifier = modifier,
        characters = uiState.charactersList,
        onItemClick = {
            onNavigateToDetails(it)
        },
    )
}

@Composable
private fun Loading(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(color = FanWhite)
    }
}

@Preview
@Composable
fun FanHomeScreenPreview() {
    FanaticsTestAppTheme {
        FanHomeScreen(onNavigateToDetails = {})
    }
}