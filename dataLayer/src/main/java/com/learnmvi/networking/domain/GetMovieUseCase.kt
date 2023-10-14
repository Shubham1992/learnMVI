package com.learnmvi.networking.domain


import com.learnmvi.networking.data.repo.MovieRepoImpl
import com.shubham.common.UIEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetMovieUseCase(val repoImpl: MovieRepoImpl) {

    operator fun invoke() = flow<UIEvent<List<Movie>>> {
        //emit(UIEvent.Success(repoImpl.getMovieList()))
    }.catch {
        emit(UIEvent.Error(message = "Something went wrong"))
    }.flowOn(Dispatchers.IO)
}