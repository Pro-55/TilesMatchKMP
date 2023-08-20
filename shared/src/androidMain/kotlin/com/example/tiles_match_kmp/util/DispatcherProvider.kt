package com.example.tiles_match_kmp.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual object DispatcherProvider {
    actual val Default: CoroutineDispatcher
        get() = Dispatchers.Default
    actual val Main: CoroutineDispatcher
        get() = Dispatchers.Main
    actual val Unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined
    actual val IO: CoroutineDispatcher
        get() = Dispatchers.IO
}

internal actual val dispatcherProvider: DispatcherProvider = DispatcherProvider