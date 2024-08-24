package com.thanasis.kottaridis.thannewskmm.android.application.base.ui.compose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.thanasis.kottaridis.thannewskmm.android.application.base.ui.BaseFragment

abstract class ComposeBaseFragment(
    layoutResId: Int,
) : BaseFragment(layoutResId) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? =
        ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MyApplicationTheme {
                    ComposableContent()
                }
            }
        }

    // Define an abstract function that returns a Composable
    @Composable
    abstract fun ComposableContent()

    /**
     * Empty Implementation of SetUpView
     *
     * Because no need to instantiate Regular views.
     * all views will be handled via composable.
     */
    override fun setupView() {}

    /**
     * Empty Implementation of setUpObservers
     *
     * Because no need to observe viewModel State
     * it will be done in ComposableContent.
     */
    override fun setUpObservers() {}
}
