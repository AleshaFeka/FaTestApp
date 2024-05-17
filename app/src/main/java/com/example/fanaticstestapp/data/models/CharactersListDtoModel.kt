package com.example.fanaticstestapp.data.models

import com.apollographql.apollo3.api.ApolloResponse
import com.example.fanaticstestapp.GetPeopleQuery
import com.example.fanaticstestapp.GetPersonQuery
import kotlin.math.roundToInt
import kotlin.math.roundToLong

data class CharactersListDtoModel(
    val characters: List<CharacterDtoModel>
) {
    companion object {
        fun fromResponse(response: ApolloResponse<GetPeopleQuery.Data>): CharactersListDtoModel {
            val list = response.data?.allPeople?.people

            val characters = list?.map {
                CharacterDtoModel(
                    id = requireNotNull(it?.id),
                    name = requireNotNull(it?.name),
                    mass = it?.mass?.roundToInt() ?: 0,
                    height = it?.height ?: 0,
                    homeland = requireNotNull(it?.homeworld?.name),
                    homelandPopulation = it?.homeworld?.population?.roundToLong() ?: 0
                )
            }

            return CharactersListDtoModel(
                characters = requireNotNull(characters)
            )
        }
    }

}