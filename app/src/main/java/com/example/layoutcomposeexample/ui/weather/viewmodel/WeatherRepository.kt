package com.example.layoutcomposeexample.ui.weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.layoutcomposeexample.domain.repository.WeatherRepository
import kotlinx.coroutines.launch


class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    fun loadWeather(city: String) {
        viewModelScope.launch {

            val weather = repository.getCurrentWeather(city)

        }
    }
}