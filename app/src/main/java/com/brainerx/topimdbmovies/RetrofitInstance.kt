package com.brainerx.topimdbmovies

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://imdb-top-100-movies.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val MoviesApi by lazy {
            retrofit.create(MoviesApi::class.java)
        }

    }
}