package com.example.layoutcomposeexample.domain.repository

import com.example.layoutcomposeexample.domain.model.WeatherModel

interface WeatherRepository {
    suspend fun getCurrentWeather(city: String): WeatherModel
}