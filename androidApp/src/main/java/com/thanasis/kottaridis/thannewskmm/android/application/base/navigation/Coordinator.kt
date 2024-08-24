package com.thanasis.kottaridis.thannewskmm.android.application.base.navigation

import android.app.Activity
import com.thanasis.kottaridis.thannewskmm.presentation.base.navigation.BaseActionHandler
import java.lang.ref.WeakReference

abstract class Coordinator<T : Activity> : BaseActionHandler {
    private var activity: WeakReference<T>? = null

    protected val safeActivity: T
        get() = activity?.get() ?: throw IllegalAccessException("activity prop is not initialized")

    fun bind(activity: T) {
        this.activity = WeakReference(activity)
    }

    fun unbind() {
        this.activity = null
    }

    // this function sets up the initial destination of coordinator.
    abstract fun start()

    /**
     * BaseActionHandler Impl.
     */

    override fun popAction() {
    }

    override fun popToRootScreenAction(animated: Boolean) {
    }

    override fun popToScreenAction(
        targetScreenType: Any,
        animated: Boolean,
    ) {
    }

    override fun popWithReloadToVCAction(targetScreenType: Any) {
    }

    override fun showLoaderAction() {
    }

    override fun hideLoaderAction() {
    }

    override fun presentFeedback() {
    }

    override fun dismissAction() {
    }
}
