package com.example.tiles_match_kmp.data.repository.impl

import com.example.tiles_match_kmp.data.model.Option
import com.example.tiles_match_kmp.data.model.Resource
import com.example.tiles_match_kmp.data.repository.contract.Repository
import com.example.tiles_match_kmp.util.Constants
import com.example.tiles_match_kmp.util.assets.JsonAssets
import com.example.tiles_match_kmp.util.wrappers.resourceFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.Json

class RepositoryImpl : Repository {

    // Global
    private val TAG = "RepositoryImpl"

    override fun getOptions(): Flow<Resource<List<Option>>> = resourceFlow {
        val data = Json.decodeFromString<List<Option?>?>(JsonAssets.data)
            ?.mapNotNull { it }
        if (data.isNullOrEmpty()) emit(Resource.Error(Constants.MSG_NO_DATA_FOUND))
        else emit(Resource.Success(data))
    }

    override fun getGameTiles() {}
}