package com.br.stone.job_interview.rickandmortytrivia.model
import kotlinx.serialization.Serializable

@Serializable
data class Character(
    private val id: Int,
    private val name: String,
    private val status: String,
    private val species: String,
    private val type: String,
    private val gender: String,
    private val origin: Origin,
    private val location: Location,
    private val image: String,
    private val episode: List<String>,
    private val url: String,
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

    fun getOrigin(): Origin {
        return origin
    }

    fun getLocation(): Location {
        return location
    }

    fun getImage(): String {
        return image
    }

    fun getEpisode(): List<String> {
        return episode
    }

    fun getCreated(): String {
        return created
    }


}