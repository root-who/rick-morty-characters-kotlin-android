package com.br.stone.job_interview.rickandmortytrivia.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.br.stone.job_interview.rickandmortytrivia.ui.components.CharacterImage
import com.br.stone.job_interview.rickandmortytrivia.ui.viewmodel.CharacterViewModel

@Composable
fun CharacterDetails(characterViewModel: CharacterViewModel) {
    val character = characterViewModel.characterByIdLiveData.value
    if (character != null) {
        Surface(
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(0.dp, 0.dp, 0.dp, 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CharacterImage(character.getImage(), 200, 250)
                Spacer(modifier = Modifier.height(110.dp))
                Column(
                    Modifier
                        .fillMaxSize(1f)
                        .padding(20.dp, 0.dp, 0.dp, 20.dp),
                    horizontalAlignment = Alignment.Start,

                    ) {
                    Text(
                        text = "Name: ${character.getName()}",
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Specie: ${character.getSpecies()}",
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Gender: ${character.getGender()}",
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Status: ${character.getStatus()}",
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(shape = CircleShape)
                                .background(character.statusColor())
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "From: ${character.getOrigin().getName()}",
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Current location: ${character.getLocation().getName()}",
                    )

                }
            }
        }

    }

}