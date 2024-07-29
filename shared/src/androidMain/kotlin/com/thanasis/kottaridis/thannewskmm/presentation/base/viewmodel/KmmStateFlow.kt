package com.thanasis.kottaridis.thannewskmm.presentation.base.viewmodel

import kotlinx.coroutines.flow.StateFlow

/**
 * KmmStateFlow Actual Impl
 * On the Android side we just delegate the implementation to the standard StateFlow so it works exactly the same way.
 */
actual class KmmStateFlow<T> actual constructor(
    source: StateFlow<T>,
) : StateFlow<T> by source
