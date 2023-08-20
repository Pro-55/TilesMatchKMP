package com.example.tiles_match_kmp.android.ui.options

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tiles_match_kmp.android.ui.options.composibles.OptionsList
import com.example.tiles_match_kmp.data.model.Option
import com.example.tiles_match_kmp.data.model.Resource

@Composable
fun OptionsScreen(
    viewModel: OptionsViewModel = hiltViewModel(),
    onClick: (Option) -> Unit
) {
    val state by viewModel.options.observeAsState(initial = Resource.Loading())

    LaunchedEffect(key1 = true) {
        if (state.data.isNullOrEmpty()) viewModel.getOptions()
    }
    if (state is Resource.Success) {
        val options = state.data
        if (options.isNullOrEmpty()) return

        OptionsList(
            options = options,
            onClick = onClick
        )
    }
}