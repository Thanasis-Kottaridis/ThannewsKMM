package com.thanasis.kottaridis.thannewskmm.presentation.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

/**
 * This is the Actual implementation of [BaseViewModel]. We also use the open keyword because this class
 * will not have any business logic. The business logig will be implemented from the viewModels that will extend this class
 * This class also extend Androidx ViewModel in order to provide the viewModelScope and be aware of view and viewModel lifecycle
 * and avoid memory leaks.
 */
actual open class BaseViewModel : ViewModel() {
    actual val scope: CoroutineScope = viewModelScope
}
