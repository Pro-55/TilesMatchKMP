package com.example.tiles_match_kmp.android.ui.options.composibles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tiles_match_kmp.data.model.Option

@Composable
fun OptionsList(
    options: List<Option>,
    onClick: (Option) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 8.dp,
            top = 8.dp,
            end = 8.dp,
            bottom = 80.dp
        )
    ) {
        items(options) { option ->
            OptionsListItem(
                modifier = Modifier.fillMaxSize(),
                option = option,
                onClick = onClick,
            )
        }
    }
}