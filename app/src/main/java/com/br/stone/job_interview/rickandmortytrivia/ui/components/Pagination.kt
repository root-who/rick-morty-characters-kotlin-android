package com.br.stone.job_interview.rickandmortytrivia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.br.stone.job_interview.rickandmortytrivia.ui.theme.RickMortyLogoCyan
import com.br.stone.job_interview.rickandmortytrivia.ui.theme.RickMortyLogoGreen
import kotlinx.coroutines.delay

@Composable
fun Pagination(currentPage:Int, lastPage:Int?, onPageChange:(Int, ()-> Unit)-> Unit, onResetScroll:()-> Unit){
    if(lastPage!=null){
        var pages = emptyList<Int>()
        var middle = false

        if(currentPage - 4 < 1){
            pages = (1..5).toList()
        }
        if(currentPage - 4 >= 1 || currentPage + 4 >= lastPage){
            middle = true
            pages = listOf(1, currentPage - 1, currentPage, currentPage + 1, lastPage)
        }
        if(currentPage == lastPage) {
            middle = false
            pages = (lastPage-4..lastPage).toList()
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row (
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                pages.forEach{
                    page ->
                    if (middle && page == lastPage ){
                        Text(
                            "...",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            ),
                        )
                    }
                    Button(
                        onClick = {
                            onPageChange(page, onResetScroll)
                        },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        RickMortyLogoCyan,
                                        RickMortyLogoGreen
                                    )
                                )
                            )
                            .let(
                                { if (page==currentPage) it.border(2.dp, Color.Black) else it }
                            )
                        ,
                        colors = ButtonDefaults.buttonColors(Color.Transparent)
                    ) {
                        Text(
                            page.toString(),
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            ),
                        )
                    }
                    if (middle && page==1 ){
                        Text(
                            "...",
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
}