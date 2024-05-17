package com.example.fanaticstestapp.ui.screens.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.fanaticstestapp.R
import com.example.fanaticstestapp.ui.components.FanScreenWrapper
import com.example.fanaticstestapp.ui.theme.FanBlack
import com.example.fanaticstestapp.ui.theme.FanBlue
import com.example.fanaticstestapp.ui.theme.FanGray
import com.example.fanaticstestapp.ui.theme.FanWhite
import com.example.fanaticstestapp.ui.theme.FanaticsTestAppTheme

@Composable
fun FanCharacterScreen(
    modifier: Modifier = Modifier,
    viewModel: FanCharacterScreenViewModel = viewModel(),
    onNavigateBack: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsState()
    FanScreenWrapper(
        modifier = modifier,
        canNavigateBack = true,
        onNavigateBack = onNavigateBack,
    ) {
        if (uiState.isLoading) Loading(modifier)
        else Content(uiState, viewModel::onViewHomeworldClicked)
        if (uiState.isBottomSheetOpened) CharacterBottomSheet(
            viewModel::onHideBottomSheet, uiState, modifier,
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun CharacterBottomSheet(
    onHideBottomSheet: () -> Unit,
    uiState: FanCharacterScreenUiState,
    modifier: Modifier = Modifier,
) {
    ModalBottomSheet(
        shape = RoundedCornerShape(16.dp),
        dragHandle = null,
        containerColor = FanGray,
        contentColor = FanBlack,
        onDismissRequest = onHideBottomSheet,
    ) {
        BottomSheetContent(
            characterName = uiState.character.name,
            characterHomeworld = uiState.character.homeLand,
            characterHomeworldPopulation = uiState.character.homelandPopulation,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun Content(
    uiState: FanCharacterScreenUiState,
    onHomeWorldClick: () -> Unit,
) {
    SpannedTextWithCharacterName(
        characterName = uiState.character.name,
        onClick = onHomeWorldClick,
        modifier = Modifier.padding(
            horizontal = 40.dp,
            vertical = 16.dp,
        ),
    )
}

@Composable
private fun Loading(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = FanWhite)
    }
}

@Composable
fun BottomSheetContent(
    modifier: Modifier = Modifier,
    characterName: String = "",
    characterHomeworld: String = "",
    characterHomeworldPopulation: String = "",
) {
    Column(modifier = modifier) {
        Text(
            text = characterName,
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp
                ),
            style = MaterialTheme.typography.headlineLarge,
        )

        Text(
            text = stringResource(R.string.homeworld, characterHomeworld),
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    top = 8.dp
                ),
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            text = stringResource(R.string.population, characterHomeworldPopulation),
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    top = 8.dp
                ),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(120.dp))
    }
}

@Composable
private fun SpannedTextWithCharacterName(
    characterName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val raw = stringResource(R.string.click_here_to_view_homeworld, characterName)
    val startIndex = raw.indexOf(stringResource(R.string.here))
    val endIndex = startIndex + stringResource(R.string.here).length
    val spannableText = buildSpannedString(characterName)

    ClickableText(
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge.copy(color = FanWhite),
        text = spannableText,
        onClick = {
            if (it in (startIndex..startIndex + endIndex)) {
                onClick()
            }
        },
    )
}

@Composable
private fun buildSpannedString(characterName: String) = buildAnnotatedString {
    append(stringResource(R.string.click))
    withStyle(
        style = SpanStyle(
            color = FanBlue, textDecoration = TextDecoration.Underline
        )
    ) {
        append(stringResource(R.string.here))
    }
    append(stringResource(R.string.to_view_homeworld, characterName))
}

@Preview
@Composable
fun FanCharacterScreenPreview() {
    FanaticsTestAppTheme {
        FanScreenWrapper {
            BottomSheetContent()
        }
    }
}
