package com.example.weatherapponcompose.data.local

import com.google.gson.Gson
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converter {
    @TypeConverter
    fun toListStr(value: List<String>): String {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun toListDouble(value: List<Double>): String {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun toListInt(value: List<Int>): String {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun fromListStr(value: String): List<String> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromListDouble(value: String): List<Double> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Double?>?>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromListInt(value: String): List<Int> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Int?>?>() {}.type
        return gson.fromJson(value, type)
    }
}
