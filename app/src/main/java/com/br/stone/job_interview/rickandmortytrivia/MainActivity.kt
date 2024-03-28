package com.br.stone.job_interview.rickandmortytrivia
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.br.stone.job_interview.rickandmortytrivia.model.Character
import com.br.stone.job_interview.rickandmortytrivia.model.Location
import com.br.stone.job_interview.rickandmortytrivia.model.Origin
import com.br.stone.job_interview.rickandmortytrivia.sample_data.sampleData
import com.br.stone.job_interview.rickandmortytrivia.ui.components.CharacterItem
import com.br.stone.job_interview.rickandmortytrivia.ui.components.CharacterList
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
                    CharacterList(characters = sampleData())
                }
            }
        }
    }
}
