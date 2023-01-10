package com.example.weatherapponcompose.data

import com.example.weatherapponcompose.data.local.Weather
import com.example.weatherapponcompose.data.local.WeatherDataBase
import com.example.weatherapponcompose.data.mappers.toWeatherDataMap
import com.example.weatherapponcompose.data.mappers.toWeatherInfo
import com.example.weatherapponcompose.data.remote.WeatherAPI
import com.example.weatherapponcompose.domain.repository.WeatherRepository
import com.example.weatherapponcompose.domain.util.Resource
import com.example.weatherapponcompose.domain.weather.WeatherInfo
import com.squareup.moshi.Json
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherAPI,
    private val dataBase: WeatherDataBase
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        val res = try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }

        if (res is Resource.Success) {
            //TODO Сохранение
            try {
                dataBase.weatherLocationDao().insertWeather(Weather(
                    id = (0..1000000).random(),
                    time = res.data?.weatherData?.time ?: emptyList(),
                    temperatures = res.data?.weatherData?.temperatures ?: emptyList(),
                    weatherCodes = res.data?.weatherData?.weatherCodes ?: emptyList(),
                    pressures = res.data?.weatherData?.pressures ?: emptyList(),
                    windSpeeds = res.data?.weatherData?.windSpeeds ?: emptyList(),
                    humidities = res.data?.weatherData?.humidities ?: emptyList(),
                ))
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return Resource.Success(data = res.data?.toWeatherInfo())
        } else {
            try {
                return Resource.Success(dataBase.weatherLocationDao().getWeather().toWeatherInfo())
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return Resource.Error("No data in database")
        }
    }
}