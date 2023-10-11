package com.learnmvi.networking.data.repo

import com.example.example.MovieListResoponse

interface MovieRepo {

    suspend fun getMovieList() : MovieListResoponse
}