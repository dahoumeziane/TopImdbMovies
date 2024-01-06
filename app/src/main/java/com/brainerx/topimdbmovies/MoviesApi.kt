package com.brainerx.topimdbmovies

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MoviesApi {

    @Headers(
        "X-RapidAPI-Key: 427b4378f8msh5b02fe06a04261ap1eacf6jsn3588768cc114",
        "X-RapidAPI-Host: imdb-top-100-movies.p.rapidapi.com",
        "Content-type: application/json"
    )
    @GET(".")
    suspend fun getTopMovies()
            : Response<ArrayList<Movie>>

    @Headers(
        "X-RapidAPI-Key: 427b4378f8msh5b02fe06a04261ap1eacf6jsn3588768cc114",
        "X-RapidAPI-Host: imdb-top-100-movies.p.rapidapi.com",
        "Content-type: application/json"
    )
    @GET("/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieID: String
    ): Response<Movie>
}