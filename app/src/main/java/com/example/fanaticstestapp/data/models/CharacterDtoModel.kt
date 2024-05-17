package com.example.fanaticstestapp.data.models

import com.apollographql.apollo3.api.ApolloResponse
import com.example.fanaticstestapp.GetPersonQuery
import kotlin.math.roundToInt
import kotlin.math.roundToLong


data class CharacterDtoModel(
    val id: String,
    val name: String,
    val height: Int,
    val mass: Int,
    val homeland: String,
    val homelandPopulation: Long,
) {
    companion object {
        fun fromResponse(response: ApolloResponse<GetPersonQuery.Data>): CharacterDtoModel {
            return CharacterDtoModel(
                id = requireNotNull(response.data?.person?.id),
                name = requireNotNull(response.data?.person?.name),
                mass = response.data?.person?.mass?.roundToInt() ?: 0,
                height = response.data?.person?.height ?: 0,
                homeland = requireNotNull(response.data?.person?.homeworld?.name),
                homelandPopulation = response.data?.person?.homeworld?.population?.roundToLong()
                    ?: 0,
            )
        }
    }
}

