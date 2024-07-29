package com.thanasis.kottaridis.thannewskmm.presentation.base.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

/**
 * This is the Actual implementation of [BaseViewModel] for iOS Platform. We also use the open keyword because this class
 * will not have any business logic. The business logic will be implemented from the viewModels that will extend this class
 *
 * @param scope: for the iOS implementation of [BaseViewModel] we will use the [Dispatchers.IO] scope in order to excecute
 * tasks in background thread
 */
actual open class BaseViewModel {
    // TODO: - Check how to pass Dispatchers.IO with injection
    actual val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    /**
     *  this method is provided only for iOS viewModels and is used in order to cancel all jobs running in this scope
     *  * when viewModel is being destroyed or the work that is curring out is no longer needed
     */
    fun clear() {
        scope.cancel()
    }
}
