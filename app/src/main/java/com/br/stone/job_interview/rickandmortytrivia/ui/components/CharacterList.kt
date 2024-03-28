package com.br.stone.job_interview.rickandmortytrivia.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.br.stone.job_interview.rickandmortytrivia.model.Character

@Composable
fun CharacterList(characters: List<Character>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(1f).
        verticalScroll(
            rememberScrollState())
        )
    {
            characters.forEach { character ->
                CharacterItem(character = character)
            }
        }
}
