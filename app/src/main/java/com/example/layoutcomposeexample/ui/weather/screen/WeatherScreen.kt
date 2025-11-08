package com.example.layoutcomposeexample.ui.weather.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.layoutcomposeexample.R
import com.example.layoutcomposeexample.ui.weather.component.TodayWeatherDisplay

// Este será el Composable principal que usará el ViewModel (cuando lo tengas)
@Composable
fun WeatherScreen(modifier: Modifier = Modifier) {
    TodayWeatherDisplay(
        location = "Santa Cruz",
        temperature = 32,
        condition = "Soleado",
        iconRes = R.drawable.img
    )
}

@Composable
//@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Preview(showBackground = true)
fun WeatherScreenPreview() {
    com.example.layoutcomposeexample.ui.theme.LayoutComposeExampleTheme {
        WeatherScreen()
    }
}