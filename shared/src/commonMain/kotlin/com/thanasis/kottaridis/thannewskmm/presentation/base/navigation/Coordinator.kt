package com.thanasis.kottaridis.thannewskmm.presentation.base.navigation

interface BaseCoordinator<Navigator> : BaseActionHandler {
    /**
     * Navigation Controller responsible for handling Coordinator navigation
     */
    var navController: Navigator?

    /**
     * Start function
     * This function is used in order to properly
     * initialize coordinator and navigation graph.
     */
    fun start()

    /**
     * Stop function
     * This function is used in order to reset Coordinator
     * and clear navController and context reference
     */
    fun stop() {
        navController = null
    }
}
