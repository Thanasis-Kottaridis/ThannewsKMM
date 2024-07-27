package com.thanasis.kottaridis.thannewskmm.domain.utils

import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

actual class Platform : BasePlatform {
    override val osName: String
        get() = UIDevice.currentDevice.systemName()
    override val osVersion: String
        get() = UIDevice.currentDevice.systemVersion
    override val deviceModel: String
        get() = UIDevice.currentDevice.model
    override val density: Int
        get() = UIScreen.mainScreen.scale().toInt()

    override fun logSystemInfo() {
        NSLog("($osName, $osVersion, $deviceModel, $density)")
    }
}
