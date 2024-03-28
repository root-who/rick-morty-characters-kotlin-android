package com.br.stone.job_interview.rickandmortytrivia.model

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    private val name: String,
    private val url: String,
) {
    fun getName(): String {
        return name
    }

    fun getUrl(): String {
        return url
    }

}