package com.brainerx.topimdbmovies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    var topMovies = MutableLiveData<ArrayList<Movie>>()
    var movie = MutableLiveData<Movie>()

    fun getMovies()= CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetrofitInstance.MoviesApi.getTopMovies()
            if(response.isSuccessful){
                CoroutineScope(Dispatchers.Main).launch{
                    topMovies.value = response.body()
                }
            }else {
                // error managament
            }
        }catch (e:Exception){

        }
    }

    fun getMovieById(movieId : String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetrofitInstance.MoviesApi.getMovieById(movieId)
            if(response.isSuccessful){
                CoroutineScope(Dispatchers.Main).launch {
                    movie.value = response.body()
                }
            }else {
                // error management
            }
        }catch (e:Exception){
            // error management
        }
    }
}