package com.example.tiles_match_kmp.android.framework

sealed class Screen(val route: String) {
    object OptionsScreen : Screen(route = "screen_options")
}