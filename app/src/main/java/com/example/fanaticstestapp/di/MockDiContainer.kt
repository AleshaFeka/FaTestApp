package com.example.fanaticstestapp.di

import com.apollographql.apollo3.ApolloClient
import com.example.fanaticstestapp.data.repository.CharactersRepository
import com.example.fanaticstestapp.data.repository.CharactersRepositoryImpl
import com.example.fanaticstestapp.data.service.CharactersService
import com.example.fanaticstestapp.data.service.CharactersServiceImpl
import com.example.fanaticstestapp.domain.interactors.CharacterInteractor
import com.example.fanaticstestapp.domain.interactors.CharacterInteractorImpl

object MockDiContainer {
    val apolloClient: ApolloClient = ApolloClient.Builder().serverUrl(CharactersService.BASE_URL).build()
    val charactersService: CharactersService = CharactersServiceImpl(apolloClient)
    val charactersRepository: CharactersRepository = CharactersRepositoryImpl(charactersService)
    val characterInteractor: CharacterInteractor = CharacterInteractorImpl(charactersRepository)
}