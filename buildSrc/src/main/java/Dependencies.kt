import Version.compose_ui_version

object Version {
    const val compose_ui_version = "1.2.0"
}

object Deps {
    const val core = "androidx.core:core-ktx:1.7.0"
    const val appcompat = "androidx.appcompat:appcompat:1.6.1"
    const val material = "com.google.android.material:material:1.9.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    const val activityCompose = "androidx.activity:activity-compose:1.3.1"
    const val composeNav = "androidx.navigation:navigation-compose:2.4.0-rc01"


    val composePreview = listOf(
        "androidx.compose.ui:ui-tooling-preview:$compose_ui_version",
        "androidx.compose.runtime:runtime:1.0.0-alpha07",
        "androidx.compose.ui:ui:1.0.0-alpha07",
        "androidx.compose.foundation:foundation:1.0.0-alpha07",
        "androidx.compose.foundation:foundation-layout:1.0.0-alpha07",
        "androidx.compose.material:material:1.0.0-alpha07",
        "androidx.compose.runtime:runtime-livedata:1.0.0-alpha07",
        "androidx.compose.ui:ui-tooling:1.0.0-alpha07"
    )

    const val junit = "junit:junit:4.13.2"
    const val extJunit = "androidx.test.ext:junit:1.1.5"


}

object HiltDeps {
    const val hilt = "com.google.dagger:hilt-android:2.44"
    const val hiltDaggerCompiler = "com.google.dagger:hilt-android-compiler:2.44"
}

object Retrofit {
 const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
}