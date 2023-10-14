package com.shubham.learnmvi

sealed class AppScreens(val route: String){
    object MainScreen : AppScreens(route = "main")
    object DetailScreen : AppScreens(route = "detail")
}
