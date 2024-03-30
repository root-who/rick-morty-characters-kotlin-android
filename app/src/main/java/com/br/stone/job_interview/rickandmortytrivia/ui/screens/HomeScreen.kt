package com.br.stone.job_interview.rickandmortytrivia.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.br.stone.job_interview.rickandmortytrivia.ui.components.CharacterList
import com.br.stone.job_interview.rickandmortytrivia.ui.components.Filter
import com.br.stone.job_interview.rickandmortytrivia.ui.components.Pagination
import com.br.stone.job_interview.rickandmortytrivia.ui.theme.RickMortyLogoCyan
import com.br.stone.job_interview.rickandmortytrivia.ui.theme.RickMortyLogoGreen
import com.br.stone.job_interview.rickandmortytrivia.ui.viewmodel.CharacterViewModel
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(onCharacterSelected: (Int) -> Unit, characterViewModel:CharacterViewModel){
    val characters = characterViewModel.charactersLiveData.value
    val currentPage = characterViewModel.charactersCurrentPage.intValue
    val lastPage = characterViewModel.characterslastPage.value
    val apiError = characterViewModel.apiRequestError.value
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    fun filter(status:String?, name:String?, onResetScroll:()-> Unit){
        characterViewModel.fetchCharacterByFilter(status, name, onResetScroll)
    }
    fun unFilter(onResetScroll:()-> Unit){
        characterViewModel.fetchCharacterByPage(currentPage, onResetScroll)
    }

    fun onPageChange(page:Int, onResetScroll:()-> Unit){
        characterViewModel.fetchCharacterByPage(page, onResetScroll)
    }

    fun resetScroll(){
        scope.launch {scrollState.scrollTo(0)}
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 20.dp)
    ) {
        Filter(onFilter=::filter, onUnfilter=::unFilter, onResetScroll=::resetScroll)
        if (characters != null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .verticalScroll(
                        scrollState
                    )
            )
            {
                CharacterList(characters = characters.results, onCharacterSelected = onCharacterSelected)
                Pagination(currentPage=currentPage, lastPage=lastPage, onPageChange=::onPageChange, onResetScroll=::resetScroll)
            }
        }
        if(apiError != null){
           Column(
               Modifier.fillMaxWidth(1f).padding(30.dp, 50.dp, 30.dp, 30.dp),
               horizontalAlignment = Alignment.CenterHorizontally
           ){
               Text(
                   apiError,
                   modifier =  Modifier.align(Alignment.CenterHorizontally)
               )
               Spacer(modifier = Modifier.height(30.dp))
               Button(
                   onClick = { characterViewModel.fetchCharacterByPage(page=currentPage, onResetScroll = ::resetScroll)},
                   shape = RoundedCornerShape(8.dp),
                   modifier = Modifier
                       .width(150.dp)
                       .background(
                           brush = Brush.horizontalGradient(
                               colors = listOf(
                                   RickMortyLogoCyan,
                                   RickMortyLogoGreen
                               )
                           )
                       ),
                   colors = ButtonDefaults.buttonColors(Color.Transparent)
               ) {
                   Text(
                       "OK!",
                       color = Color.Black,
                       style = TextStyle(
                           fontSize = 18.sp,
                           fontWeight = FontWeight.Bold
                       ),
                   )
               }
           }
        }

    }
}