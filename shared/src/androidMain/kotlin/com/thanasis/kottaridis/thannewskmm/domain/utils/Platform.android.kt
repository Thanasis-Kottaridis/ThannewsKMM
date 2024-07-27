package com.thanasis.kottaridis.thannewskmm.domain.utils

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

actual class Platform : BasePlatform {
    override val osName: String
        get() = "Android"
    override val osVersion: String
        get() = "${Build.VERSION.SDK_INT}"
    override val deviceModel: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"
    override val density: Int
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    override fun logSystemInfo() {
        Log.d("ThannewsKMM Platform:", "($osName, $osVersion, $deviceModel, $density)")
    }
}
