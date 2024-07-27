package com.thanasis.kottaridis.thannewskmm.domain.utils

/**
 * **Expect Keyword**
 *
 * It is a KMM Specific keyword that we can add to a function or a class
 * by using this keyword we are declaring the signature of the function or a class
 * without adding any implementation in a shared module
 * and we are expecting androidMain and iosMain modules to implement the business logic
 * using platform specific code.
 *
 * @documentation
 */

interface BasePlatform {
    val osName: String
    val osVersion: String
    val deviceModel: String
    val density: Int

    fun logSystemInfo()

    fun toItemsList(): List<Pair<String, String>> =
        listOf(
            "OS Name" to osName,
            "OS Version" to osVersion,
            "Device Model" to deviceModel,
            "Density" to density.toString(),
        )
}

expect class Platform : BasePlatform
