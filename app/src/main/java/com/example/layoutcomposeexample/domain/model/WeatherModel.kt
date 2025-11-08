package com.example.layoutcomposeexample.domain.model


data class WeatherModel(
    val location: String,
    val temperature: Double,
    val condition: String,
    val iconRes: Int
) {

    fun getFormattedTemperature(): String {
        return "${temperature.toInt()}°C"
    }
}