package com.br.stone.job_interview.rickandmortytrivia.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.br.stone.job_interview.rickandmortytrivia.data.model.Character

@Composable
fun CharacterList(characters: List<Character>, onCharacterSelected: (Int) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(1f)
            .verticalScroll(
                rememberScrollState()
            )
    )
    {
        characters.forEach { character ->
            Surface(
                onClick = { onCharacterSelected(character.getId()) },
            ) {

                CharacterItem(character = character)
            }

        }
    }
}
