package com.example.weatherapponcompose.domain.repository

import com.example.weatherapponcompose.domain.util.Resource
import com.example.weatherapponcompose.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double) : Resource<WeatherInfo>
}