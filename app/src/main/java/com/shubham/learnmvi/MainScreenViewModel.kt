package com.shubham.learnmvi

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {

    val state = MutableStateFlow(MainScreenModel(count = 0))

    fun handleIntent(intent: MainScreenIntent) {
        when (intent) {
            is MainScreenIntent.Increment -> {
                state.value = state.value.copy(count = state.value.count + 1)
            }
            is MainScreenIntent.Decrement -> {
                state.value = state.value.copy(count = state.value.count - 1)

            }
        }
    }
}