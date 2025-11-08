package com.example.layoutcomposeexample.ui.weather.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CarruselSimple(){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),

        modifier = Modifier.fillMaxWidth()
    ) {
        items(10) { index ->
            Card(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                    colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ){
                Text(text = "Card $index")
            }
        }
    }
}