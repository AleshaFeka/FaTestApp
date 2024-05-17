package com.example.fanaticstestapp.data.repository

import com.example.fanaticstestapp.data.models.CharacterDtoModel
import com.example.fanaticstestapp.data.models.CharactersListDtoModel
import com.example.fanaticstestapp.data.service.CharactersService

interface CharactersRepository {
    suspend fun getCharactersList(): CharactersListDtoModel
    suspend fun getCharacter(characterId: String): CharacterDtoModel
}

class CharactersRepositoryImpl(private val service: CharactersService): CharactersRepository {
    override suspend fun getCharactersList(): CharactersListDtoModel {
        return service.getCharactersList()
    }

    override suspend fun getCharacter(characterId: String): CharacterDtoModel {
        return service.getCharacter(characterId)
    }
}