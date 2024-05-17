package com.example.fanaticstestapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fanaticstestapp.ui.models.CharacterUiModel
import com.example.fanaticstestapp.ui.theme.FanaticsTestAppTheme

@Composable
fun FanCharactersListItem(
    item: CharacterUiModel,
    onIconClick: (CharacterUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Divider(
            modifier = Modifier.padding(top = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text(text = item.name)
                Text(text = "Height: ${item.height}")
                Text(text = "Mass: ${item.mass}")
            }
            IconButton(
                modifier = Modifier.padding(top = 4.dp),
                onClick = {
                    onIconClick(item)
                },
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun FanCharactersListItemPreview() {
    FanaticsTestAppTheme {
        FanScreenWrapper {
            FanCharactersListItem(
                onIconClick = {},
                item = CharacterUiModel(
                    mass = "50kg", height = "100cm", name = "Nameee"
                ),
            )
        }
    }
}

