package com.br.stone.job_interview.rickandmortytrivia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.br.stone.job_interview.rickandmortytrivia.ui.theme.RickMortyLogoCyan
import com.br.stone.job_interview.rickandmortytrivia.ui.theme.RickMortyLogoGreen

@Composable
fun CharacterImage(urlImage: String, coverSize:Int, imageWidth:Int) {
    Box(modifier = Modifier
        .height(coverSize.dp)
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
                .width(imageWidth.dp)
                .offset(y=100.dp/2)
                .aspectRatio(1f)
                .clip(CircleShape)
                .align(Alignment.BottomCenter)
        )
    }
}