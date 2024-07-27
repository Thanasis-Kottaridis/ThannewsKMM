package com.thanasis.kottaridis.thannewskmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform