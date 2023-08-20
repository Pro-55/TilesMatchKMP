package com.example.tiles_match_kmp.android.ui.options.composibles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.tiles_match_kmp.android.R
import com.example.tiles_match_kmp.data.model.Option

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun OptionsListItem(
    modifier: Modifier = Modifier,
    option: Option,
    onClick: (Option) -> Unit
) {
    val url = remember {
        when (option._id) {
            0 -> R.drawable.slytherin
            1 -> R.drawable.gryffindor
            2 -> R.drawable.hufflepuff
            3 -> R.drawable.ravenclaw
            else -> option.url
        }
    }
    Surface(
        modifier = modifier
            .aspectRatio(1F)
            .padding(all = 4.dp)
            .clickable { onClick(option) },
        shape = RoundedCornerShape(size = 8.dp),
    ) {
        GlideImage(
            modifier = Modifier
                .fillMaxSize(),
            model = url,
            contentDescription = option.title,
        )
    }
}