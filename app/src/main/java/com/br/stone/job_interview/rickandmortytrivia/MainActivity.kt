package com.br.stone.job_interview.rickandmortytrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.br.stone.job_interview.rickandmortytrivia.model.Character
import com.br.stone.job_interview.rickandmortytrivia.ui.components.CharacterItem
import com.br.stone.job_interview.rickandmortytrivia.ui.theme.RickAndMortyTriviaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTriviaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background,

                ) {
                    CharacterItem(
                        Character(
                            "Rick Sanchez",
                            "Alive",
                            "Human",
                            "",
                            "Male",
                            "Earth (C-137)",
                            "Citadel of Ricks",
                            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                            listOf(
                                "https://rickandmortyapi.com/api/episode/1",
                                "https://rickandmortyapi.com/api/episode/2"
                            ),
                            "2017-11-04T18:48:46.250Z"
                        )
                    )
                }
            }
        }
    }
}
