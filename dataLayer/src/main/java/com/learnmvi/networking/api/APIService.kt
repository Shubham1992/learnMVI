package com.learnmvi.networking.api

import com.example.example.MovieListResoponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface APIService {

    @GET("movie/popular?api_key=378aec4d34b39c552a9365436d28408f&language=en-US")
    suspend fun getMoviesList(): MovieListResoponse
}