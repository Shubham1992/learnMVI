package com.learnmvi.networking.data.repo

import com.example.example.MovieListResoponse
import com.learnmvi.networking.APIService
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(val apiService: APIService) : MovieRepo{


    override suspend fun getMovieList(): MovieListResoponse {

        return apiService.getMoviesList(
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzNzhhZWM0ZDM0YjM5YzU1MmE9zNzhhZWM0ZDM0YjM5YzU1MmE9zNzhhZWM0ZDM0YjM5YzU1MmE",
            "en-US",
            1
        )
    }

}