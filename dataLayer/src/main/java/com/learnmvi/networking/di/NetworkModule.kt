package com.learnmvi.networking.di

import com.learnmvi.networking.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideApiService(): APIService {
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/3")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(APIService::class.java)
    }
}