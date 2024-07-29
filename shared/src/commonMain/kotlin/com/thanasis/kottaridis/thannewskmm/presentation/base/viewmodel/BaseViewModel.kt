package com.thanasis.kottaridis.thannewskmm.presentation.base.viewmodel

import kotlinx.coroutines.CoroutineScope

/**
 * This is an Open Expect class witch means
 * 1. that iosMain and AndroidMain should implement the functionality of this abstract class using platform specific implementation
 * 2. that this class can be extended from our future viewModels
 *
 * @param scope: The CoroutineScope that will be used for the excecution of the tasks in this viewModel.
 * @param
 */
expect open class BaseViewModel() {
    val scope: CoroutineScope
}
