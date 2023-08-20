package com.example.tiles_match_kmp.util.extensions

import com.example.tiles_match_kmp.data.model.Resource
import com.example.tiles_match_kmp.util.Constants
import com.example.tiles_match_kmp.util.DispatcherProvider
import com.example.tiles_match_kmp.util.wrappers.NativeFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

/**
 * converts regular flow into resource flow
 * @return resource flow for given flow
 */
fun <T> Flow<Resource<T>>.asResourceFlow(): Flow<Resource<T>> =
    onStart { emit(Resource.Loading()) }
        .distinctUntilChanged()
        .catch {
            it.printStackTrace()
            when (it) {
                is IllegalArgumentException -> println("RF => TestLog: IllegalArgumentException")
                else -> println("RF => TestLog: Exception")
            }
            emit(Resource.Error(msg = Constants.MSG_SOMETHING_WENT_WRONG))
        }
        .flowOn(DispatcherProvider.IO)

fun <T> Flow<Resource<T>>.asNativeFlow(): NativeFlow<T> = NativeFlow(this)