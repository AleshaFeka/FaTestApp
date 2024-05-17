package com.example.fanaticstestapp.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fanaticstestapp.di.MockDiContainer
import com.example.fanaticstestapp.domain.interactors.CharacterInteractor
import com.example.fanaticstestapp.navigation.CHARACTER_ID
import com.example.fanaticstestapp.ui.models.CharacterUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FanCharacterScreenViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val interactor: CharacterInteractor = MockDiContainer.characterInteractor
    private val characterId: String = checkNotNull(savedStateHandle[CHARACTER_ID])

    private val _uiState = MutableStateFlow(FanCharacterScreenUiState())
    val uiState: StateFlow<FanCharacterScreenUiState>
        get() = _uiState.asStateFlow()

    init {
        _uiState.value = FanCharacterScreenUiState(
            isBottomSheetOpened = false,
            isLoading = true
        )

        viewModelScope.launch {
            val characterDto = interactor.getCharacter(characterId)

            _uiState.value = FanCharacterScreenUiState(
                isBottomSheetOpened = false,
                character = CharacterUiModel.fromDto(characterDto),
                isLoading = false
            )
        }

    }

    fun onViewHomeworldClicked() {
        _uiState.value = _uiState.value.copy(isBottomSheetOpened = true)
    }

    fun onHideBottomSheet() {
        _uiState.value = _uiState.value.copy(isBottomSheetOpened = false)
    }
}