package com.br.stone.job_interview.rickandmortytrivia.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.br.stone.job_interview.rickandmortytrivia.data.model.Character

@Composable
fun CharacterItem(character: Character) {
    Surface(
        modifier = Modifier
            .padding(30.dp),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 10.dp,
    ) {
        Column(
            modifier = Modifier
                .width(310.dp)
                .padding(0.dp, 0.dp, 0.dp, 15.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CharacterImage(character.getImage(), 120, 180)
            Spacer(modifier = Modifier.height(110.dp))
            Column(
                Modifier
                    .width(300.dp)
                    .padding(5.dp, 0.dp),
                horizontalAlignment = Alignment.Start,

            ) {
                Text(
                    text = "Name: ${character.getName()}",
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "From: ${character.getOrigin().getName()}",
                )
            }
        }
    }
}


