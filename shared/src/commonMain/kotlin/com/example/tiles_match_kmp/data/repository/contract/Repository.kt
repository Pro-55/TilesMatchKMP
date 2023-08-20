package com.example.tiles_match_kmp.data.repository.contract

import com.example.tiles_match_kmp.data.model.Option
import com.example.tiles_match_kmp.data.model.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getOptions(): Flow<Resource<List<Option>>>
    fun getGameTiles()
}