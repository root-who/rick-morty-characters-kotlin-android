package com.br.stone.job_interview.rickandmortytrivia.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterApiResponseInfo(
     val count: Int,
     val pages: Int,
     val next: String?,
     val prev: String?
) {

}

@Serializable
data class CharacterApiResponse(
     val info: CharacterApiResponseInfo,
     val results: List<Character>
) {

}