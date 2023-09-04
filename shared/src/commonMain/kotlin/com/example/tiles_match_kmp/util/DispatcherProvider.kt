package com.example.tiles_match_kmp.util

import kotlinx.coroutines.CoroutineDispatcher

expect object DispatcherProvider {
    val Default: CoroutineDispatcher
    val Main: CoroutineDispatcher
    val Unconfined: CoroutineDispatcher
    val IO: CoroutineDispatcher
}