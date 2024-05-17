package com.example.fanaticstestapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fanaticstestapp.ui.screens.home.FanHomeScreen
import com.example.fanaticstestapp.ui.models.CharacterUiModel
import com.example.fanaticstestapp.ui.theme.FanaticsTestAppTheme

@Composable
fun FanCharactersList(
    characters: List<CharacterUiModel>,
    onItemClick: (CharacterUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = modifier) {
            items(characters) { model ->
                FanCharactersListItem(
                    item = model,
                    onIconClick = onItemClick
                )
            }
        }
    }
}

@Preview
@Composable
fun PrFanCharactersList() {
    FanaticsTestAppTheme {
        FanHomeScreen({})
    }
}