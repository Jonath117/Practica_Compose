package com.example.layoutcomposeexample.data.repository

import com.example.layoutcomposeexample.domain.model.WeatherModel
import com.example.layoutcomposeexample.domain.repository.WeatherRepository

class WeatherRepositoryProxy(
    private val realRepository: RemoteWeatherRepository
) : WeatherRepository {
    private val cache = mutableMapOf<String, WeatherModel>()

    override suspend fun getCurrentWeather(city: String): WeatherModel {
        if (cache.containsKey(city)) {
            println("-> [PROXY] Retornando clima de $city desde CACHE.")
            return cache.getValue(city)
        }

        println("-> [PROXY] No hay caché. Delegando a la API.")
        val weatherData = realRepository.getCurrentWeather(city)

        cache[city] = weatherData

        return weatherData
    }
}