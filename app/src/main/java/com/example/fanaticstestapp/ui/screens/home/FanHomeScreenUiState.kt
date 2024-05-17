package com.example.fanaticstestapp.ui.screens.home

import com.example.fanaticstestapp.ui.models.CharacterUiModel

data class FanHomeScreenUiState(
    val charactersList: List<CharacterUiModel> = emptyList(),
    val isLoading:Boolean = true,
)