package com.example.fanaticstestapp.data.service

import com.apollographql.apollo3.ApolloClient
import com.example.fanaticstestapp.GetPeopleQuery
import com.example.fanaticstestapp.GetPersonQuery
import com.example.fanaticstestapp.data.models.CharacterDtoModel
import com.example.fanaticstestapp.data.models.CharactersListDtoModel


interface CharactersService {
    companion object {
        const val BASE_URL = "https://swapi-graphql.eskerda.vercel.app/"
    }

    suspend fun getCharactersList(): CharactersListDtoModel
    suspend fun getCharacter(characterId: String): CharacterDtoModel
}

class CharactersServiceImpl(private val apolloClient: ApolloClient) : CharactersService {
    override suspend fun getCharactersList(): CharactersListDtoModel {
        val response = apolloClient.query(GetPeopleQuery()).execute()
        return CharactersListDtoModel.fromResponse(response)
    }

    override suspend fun getCharacter(characterId: String): CharacterDtoModel {
        val response = apolloClient.query(GetPersonQuery(characterId)).execute()
        return CharacterDtoModel.fromResponse(response)
    }
}