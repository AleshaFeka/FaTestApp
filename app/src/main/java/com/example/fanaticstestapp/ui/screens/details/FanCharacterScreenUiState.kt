package com.example.fanaticstestapp.ui.screens.details

import com.example.fanaticstestapp.ui.models.CharacterUiModel

data class FanCharacterScreenUiState(
    val character: CharacterUiModel = CharacterUiModel(),
    val isBottomSheetOpened: Boolean = false,
    val isLoading: Boolean = true,
)
