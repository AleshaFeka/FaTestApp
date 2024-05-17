package com.example.fanaticstestapp.domain.interactors

import com.example.fanaticstestapp.data.models.CharacterDtoModel
import com.example.fanaticstestapp.data.repository.CharactersRepository

interface CharacterInteractor {
    suspend fun getCharactersList(): List<CharacterDtoModel>
    suspend fun getCharacter(characterId: String): CharacterDtoModel
}

class CharacterInteractorImpl(private val repository: CharactersRepository) : CharacterInteractor {
    override suspend fun getCharactersList(): List<CharacterDtoModel> {
        return repository.getCharactersList().characters
    }

    override suspend fun getCharacter(characterId: String): CharacterDtoModel {
        return repository.getCharacter(characterId)
    }
}