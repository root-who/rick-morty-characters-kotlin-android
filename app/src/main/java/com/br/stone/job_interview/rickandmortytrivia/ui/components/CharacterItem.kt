package com.br.stone.job_interview.rickandmortytrivia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.br.stone.job_interview.rickandmortytrivia.model.Character
import com.br.stone.job_interview.rickandmortytrivia.ui.theme.RickMortyLogoCyan
import com.br.stone.job_interview.rickandmortytrivia.ui.theme.RickMortyLogoGreen

@Composable
fun CharacterImage(urlImage: String) {
    Box(modifier = Modifier
        .height(100.dp)
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    RickMortyLogoCyan,
                    RickMortyLogoGreen
                )
            )
        ).fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = urlImage,
            contentDescription = "Rick and Morty's character Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(180.dp)
                .offset(y=100.dp/2)
                .aspectRatio(1f)
                .clip(CircleShape)
                .align(Alignment.BottomCenter)
        )
    }
}

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
                .width(300.dp)
                .padding(0.dp, 0.dp, 0.dp, 15.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CharacterImage(character.getImage())
            Spacer(modifier = Modifier.height(110.dp))
            Column(
                modifier = Modifier

            ) {
                Text(
                    text = "Name: ${character.getName()}",
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Specie: ${character.getSpecies()}",
                )
            }
        }

    }
}


