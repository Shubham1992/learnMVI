package com.learnmvi.networking

import com.example.example.MovieListResoponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface APIService {

    @GET("movie/popular")
    suspend fun getMoviesList(
        @Header("Authorization") authorizationHeader: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): MovieListResoponse
}