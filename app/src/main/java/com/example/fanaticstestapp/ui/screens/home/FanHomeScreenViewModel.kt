package com.example.fanaticstestapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fanaticstestapp.di.MockDiContainer
import com.example.fanaticstestapp.domain.interactors.CharacterInteractor
import com.example.fanaticstestapp.ui.models.CharacterUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FanHomeScreenViewModel : ViewModel() {
    private val interactor: CharacterInteractor = MockDiContainer.characterInteractor

    private val _uiState = MutableStateFlow(FanHomeScreenUiState())
    val uiState: StateFlow<FanHomeScreenUiState>
        get() = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        _uiState.value = FanHomeScreenUiState(
            charactersList = emptyList(),
            isLoading = true,
        )

        viewModelScope.launch {
            val characters = interactor.getCharactersList()

            if (characters.isNotEmpty()) {
                _uiState.value = FanHomeScreenUiState(
                    charactersList = characters.map {
                        CharacterUiModel.fromDto(it)
                    },
                    isLoading = false,
                )
            }
        }
    }
}