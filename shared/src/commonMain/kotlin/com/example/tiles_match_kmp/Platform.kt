package com.example.tiles_match_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform