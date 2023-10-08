package com.shubham.learnmvi

sealed class MainScreenIntent() {
    object Increment : MainScreenIntent()
    object Decrement : MainScreenIntent()
}
