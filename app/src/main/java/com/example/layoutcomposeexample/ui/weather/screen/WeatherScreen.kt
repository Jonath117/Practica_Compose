package com.example.layoutcomposeexample.ui.weather.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.layoutcomposeexample.R
import com.example.layoutcomposeexample.ui.weather.component.BottomBar
import com.example.layoutcomposeexample.ui.weather.component.TodayWeatherDisplay

// Este será el Composable principal que usará el ViewModel (cuando lo tengas)
@Composable
fun WeatherScreen(navController: NavController, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Scaffold (
        bottomBar = {
            BottomBar(navController = navController)
        }
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            TodayWeatherDisplay(
                location = "Santa Cruz",
                temperature = 32,
                condition = "Soleado",
                iconRes = R.drawable.img
            )
        }
    }

}

@Composable
//@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Preview(showBackground = true)
fun WeatherScreenPreview() {
    com.example.layoutcomposeexample.ui.theme.LayoutComposeExampleTheme {
        //WeatherScreen()
    }
}