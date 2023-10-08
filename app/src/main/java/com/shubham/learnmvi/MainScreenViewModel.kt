package com.shubham.learnmvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainScreenViewModel : ViewModel(){

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