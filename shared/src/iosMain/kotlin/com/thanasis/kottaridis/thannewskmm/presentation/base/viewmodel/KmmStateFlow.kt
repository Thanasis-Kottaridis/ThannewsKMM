package com.thanasis.kottaridis.thannewskmm.presentation.base.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach

/*
 * This is a functional interface in Kotlin
 * an interface that contains one and only method to be implemented
 *
 * so it can be declared as `fun interface MyInterface`
 * and the implementation can be like
 *
 * @example: MyInterface { "method body" }
 */
fun interface KmmSubscription {
    fun unsubscribe()
}

/**
 * KmmStateFlow iOS Actual Impl
 * this implementation converts the coroutines StateFlow to an iOS friendly implementation
 * by converting flow events into callbacks that are more familiar to iOS implementation.
 */
actual class KmmStateFlow<T> actual constructor(
    private val source: StateFlow<T>,
) : StateFlow<T> by source {
    fun subscribe(
        onEach: (T) -> Unit,
        onError: (error: Throwable?, completed: Boolean) -> Unit,
    ): KmmSubscription {
        val scope = CoroutineScope(Job() + Dispatchers.Main)
        source
            .onEach { onEach(it) }
            .catch { onError(it, false) }
            .onCompletion { onError(null, true) }
            .launchIn(scope)
        return KmmSubscription { scope.cancel() }
    }
}
