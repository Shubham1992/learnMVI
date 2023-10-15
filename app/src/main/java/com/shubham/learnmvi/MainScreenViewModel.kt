package com.shubham.learnmvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learnmvi.networking.data.repo.MovieRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val repo: MovieRepoImpl) : ViewModel() {

    val state = MutableStateFlow(MainScreenModel(count = 0))

    fun handleIntent(intent: MainScreenIntent) {

        viewModelScope.launch {

            when (intent) {
                is MainScreenIntent.Increment -> {
                    state.value = state.value.copy(count = state.value.count + 1)
                }
                is MainScreenIntent.Decrement -> {
                    state.value = state.value.copy(count = state.value.count - 1)
                }
                is MainScreenIntent.GetMovies -> {
                    state.value = state.value.copy(movieListResoponse = repo.getMovieList())
                }
            }
        }
    }
}