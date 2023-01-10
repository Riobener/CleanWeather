package com.example.weatherapponcompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapponcompose.domain.weather.WeatherInfo

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather_table")
    fun getWeather(): Weather

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weather: Weather)
}