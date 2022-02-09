package id.ghodel.weatherapp.data.repository

import id.ghodel.weatherapp.data.remote.ApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val apiService: ApiService
    ) {

    suspend fun getWeather() = apiService.getWeather()
}