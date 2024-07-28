package com.thanasis.kottaridis.thannewskmm.presentation.base.navigation

interface BaseActionHandler {
    fun popAction()

    fun popToRootScreenAction(animated: Boolean)

    fun popToScreenAction(
        targetScreenType: Any,
        animated: Boolean,
    )

    fun popWithReloadToVCAction(targetScreenType: Any)

    fun showLoaderAction()

    fun hideLoaderAction()

    fun presentFeedback()

    fun dismissAction()
}
