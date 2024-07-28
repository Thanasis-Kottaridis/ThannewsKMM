package com.thanasis.kottaridis.thannewskmm.domain.utils

import com.thanasis.kottaridis.thannewskmm.domain.models.platform.PlatformInfo

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

    fun toItemsList(): List<PlatformInfo> =
        listOf(
            PlatformInfo(1, "OS Name", osName),
            PlatformInfo(2, "OS Version", osVersion),
            PlatformInfo(3, "Device Model", deviceModel),
            PlatformInfo(4, "Density", density.toString()),
        )
}

expect class Platform : BasePlatform
