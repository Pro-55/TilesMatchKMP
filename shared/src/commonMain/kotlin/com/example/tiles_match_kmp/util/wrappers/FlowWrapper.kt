package com.example.tiles_match_kmp.util.wrappers

import com.example.tiles_match_kmp.data.model.Resource
import com.example.tiles_match_kmp.util.extensions.asResourceFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * wraps passed block in flow and converts it into resource flow
 *
 * @param block block of code to be executed
 * @return regular flow converted into resource flow
 */
fun <T> resourceFlow(
    block: suspend FlowCollector<Resource<T>>.() -> Unit
): Flow<Resource<T>> = flow(block).asResourceFlow()

/**
 *
 */
class NativeFlow<T>(
    private val resourceFlow: Flow<Resource<T>>
) : Flow<Resource<T>> by resourceFlow {
    fun callbacks(
        onLoading: () -> Unit,
        onSuccess: (T?) -> Unit,
        onError: (msg: String?) -> Unit
    ) {
        onEach {
            when (it) {
                is Resource.Loading -> onLoading()
                is Resource.Success -> onSuccess(it.data)
                is Resource.Error -> onError(it.msg)
            }
        }
            .launchIn(CoroutineScope(Dispatchers.Main))
    }
}