package com.thanasis.kottaridis.thannewskmm.presentation.base.viewmodel

import kotlinx.coroutines.flow.StateFlow

/**
 * **KmmStateFlow**
 * This is a custom State flow implementation in order to make Swift code able to subscribe in Coroutines StateFlows
 * and listen on MVIState changes.
 */
expect class KmmStateFlow<T>(
    source: StateFlow<T>,
) : StateFlow<T>

fun <T> StateFlow<T>.asKmmStateFlow(): KmmStateFlow<T> = KmmStateFlow(this)
