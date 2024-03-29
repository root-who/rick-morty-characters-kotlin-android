package com.br.stone.job_interview.rickandmortytrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.br.stone.job_interview.rickandmortytrivia.ui.components.CharacterDetails
import com.br.stone.job_interview.rickandmortytrivia.ui.theme.RickAndMortyTriviaTheme
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.br.stone.job_interview.rickandmortytrivia.ui.screens.HomeScreen
import com.br.stone.job_interview.rickandmortytrivia.ui.viewmodel.CharacterViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RickAndMortyTriviaTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navController = rememberNavController()
                    val characterViewModel = viewModel<CharacterViewModel>()
                    NavHost(navController = navController, startDestination = "homeScreen") {
                        composable("homeScreen") {
                            HomeScreen(
                                onCharacterSelected = { characterId ->
                                    characterViewModel.getCharacterByID(characterId)
                                    navController.navigate(
                                        "characterDetailScreen/${characterId}"
                                    )
                                },
                                characterViewModel = characterViewModel
                            )
                        }
                        composable(
                            "characterDetailScreen/{characterId}",
                            arguments = listOf(navArgument("characterId") {
                                type = NavType.IntType
                            })
                        ) { backStackEntry ->
                            val characterId = backStackEntry.arguments?.getInt("characterId") ?: -1
                            CharacterDetails(characterViewModel = characterViewModel)
                        }
                    }


                }
            }
        }
    }
}
