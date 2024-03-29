package com.br.stone.job_interview.rickandmortytrivia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.br.stone.job_interview.rickandmortytrivia.ui.theme.RickMortyLogoCyan
import com.br.stone.job_interview.rickandmortytrivia.ui.theme.RickMortyLogoGreen

@Composable
fun Filter(){
    var name by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var showFilter by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(0.dp, 25.dp, 0.dp, 15.dp)
    ){
        if(showFilter){
            Row (
                modifier = Modifier.width(350.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Ícone de fechar",
                    tint = Color.Black,
                    modifier = Modifier
                        .clickable { showFilter = !showFilter}.size(40.dp)
                )
            }
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = {
                    Text("Character name")
                },
                modifier = Modifier.width(350.dp)

            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.width(350.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("Alive", "Dead", "unknown").forEach{
                        it ->
                    Button(
                        onClick = { status = it },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.LightGray)
                    ) {
                        Text(
                            it,
                            color = Color.Black
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .width(350.dp)
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
                    "Filter",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }else{
            Row (
                modifier = Modifier.width(350.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Ícone de pesquisa",
                    tint = Color.Black,
                    modifier = Modifier
                        .clickable { showFilter = !showFilter}.size(40.dp)
                )
            }
        }

    }
}