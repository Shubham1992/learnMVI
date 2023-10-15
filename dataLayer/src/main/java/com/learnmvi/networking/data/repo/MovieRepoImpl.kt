package com.learnmvi.networking.data.repo

import com.example.example.MovieListResoponse
import com.learnmvi.networking.BuildConfig
import com.learnmvi.networking.api.APIService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MovieRepoImpl @Inject constructor() : MovieRepo {

    lateinit var okHttpClient: OkHttpClient

    override suspend fun getMovieList(): MovieListResoponse {

        okHttpClient = if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        } else {
            OkHttpClient
                .Builder()
                .build()
        }

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/3/")
            .client(okHttpClient)
            .build().create(APIService::class.java)
            .getMoviesList()
    }

}

//curl --request GET \
//--url 'https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc' \
//--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzNzhhZWM0ZDM0YjM5YzU1MmE5MzY1NDM2ZDI4NDA4ZiIsInN1YiI6IjU2ZmExZWU0YzNhMzY4MTkzNTAwMThmMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8ozh1mAgO7Xp2XLxNk2Vz_A7ApOZv8QTgXhSOg62VzY' \
//--header 'accept: application/json'