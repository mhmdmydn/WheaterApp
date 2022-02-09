package id.ghodel.weatherapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.ghodel.weatherapp.data.model.Weather
import id.ghodel.weatherapp.data.repository.WeatherRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
public class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository) : ViewModel(){

    private val _response = MutableLiveData<Weather>()
    val weatherResponse: LiveData<Weather>
        get() = _response

    init {
        getWeather()
    }

    private fun getWeather() = viewModelScope.launch {
        weatherRepository.getWeather().let { response ->
            if(response.isSuccessful){
                _response.postValue(response.body()!!)
            }else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }
}