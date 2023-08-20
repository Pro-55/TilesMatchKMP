package com.example.tiles_match_kmp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Option(
    val _id: Int,
    val title: String,
    val url: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Option

        if (_id != other._id) return false
        if (title != other.title) return false
        if (url != other.url) return false

        return true
    }

    override fun hashCode(): Int {
        var result = _id
        result = 31 * result + title.hashCode()
        result = 31 * result + url.hashCode()
        return result
    }
}