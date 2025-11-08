package com.example.layoutcomposeexample.data.repository

import com.example.layoutcomposeexample.R
import com.example.layoutcomposeexample.domain.model.WeatherModel
import com.example.layoutcomposeexample.domain.repository.WeatherRepository

class RemoteWeatherRepository : WeatherRepository {
    override suspend fun getCurrentWeather(city: String): WeatherModel {
        println("-> [API] Solicitando clima actual para $city")

        kotlinx.coroutines.delay(1000)


        return WeatherModel(
            location = city,
            temperature = 32.5,
            condition = "Soleado",
            iconRes = R.drawable.img
        )
    }
}