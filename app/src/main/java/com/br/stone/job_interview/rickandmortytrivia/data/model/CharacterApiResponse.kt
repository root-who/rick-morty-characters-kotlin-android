package com.br.stone.job_interview.rickandmortytrivia.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterApiResponseInfo(
    private val count: Int,
    private val pages: Int,
    private val next: String?,
    private val prev: String?
) {

}

@Serializable
data class CharacterApiResponse(
     val info: CharacterApiResponseInfo,
     val results: List<Character>
) {

}