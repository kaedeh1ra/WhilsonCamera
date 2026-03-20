package ru.kaed.phys

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform