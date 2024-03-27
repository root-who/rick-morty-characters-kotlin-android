package com.br.stone.job_interview.rickandmortytrivia.model

class Character(
    private val name: String,
    private val status: String,
    private val species: String,
    private val type: String,
    private val gender: String,
    private val origin: String,
    private val location: String,
    private val urlImage: String,
    private val episode: List<String>,
    private val created: String,
) {
    fun getName(): String {
        return name
    }

    fun getStatus(): String {
        return status
    }

    fun getSpecies(): String {
        return species
    }

    fun getType(): String {
        return type
    }

    fun getGender(): String {
        return gender
    }

    fun getOrigin(): String {
        return origin
    }

    fun getLocation(): String {
        return location
    }

    fun getUrlImage(): String {
        return urlImage
    }

    fun getEpisode(): List<String> {
        return episode
    }

    fun getCreated(): String {
        return created
    }


}