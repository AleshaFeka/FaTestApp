package com.example.fanaticstestapp.ui.models

import com.example.fanaticstestapp.data.models.CharacterDtoModel

data class CharacterUiModel(
    val id: String = "",
    val name: String = "",
    val height: String = "",
    val mass: String = "",
    val homeLand: String = "",
    val homelandPopulation: String = "",
    ) {

    companion object {
        fun fromDto(dto: CharacterDtoModel): CharacterUiModel {
            return CharacterUiModel(
                id = dto.id,
                name = dto.name,
                mass = dto.mass.toString(),
                height = dto.height.toString(),
                homeLand = dto.homeland,
                homelandPopulation = dto.homelandPopulation.toString()
            )
        }
    }
}
