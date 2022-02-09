package id.ghodel.weatherapp.data.remote

import id.ghodel.weatherapp.data.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("weather/Indonesia")
    suspend fun getWeather(): Response<Weather>

}