package org.weverton.conversordemoeda

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform