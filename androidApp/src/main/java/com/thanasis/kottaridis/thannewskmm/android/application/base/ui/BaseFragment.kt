package com.thanasis.kottaridis.thannewskmm.android.application.base.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment(
    layoutResId: Int,
) : Fragment(layoutResId) {
    /**
     * Variables to override in order to change the load behavior or time
     */
    protected open var shouldReLoadDataOnBack = false

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: Add bottom nav handler if needed.

        initArgs()
        setupView()
        setUpObservers()
        populateData()
    }

    /**
     *  Base Fragment Template functions
     */
    open fun initArgs() {} // optional implementation in case we have arguments to pass in this fragment

    abstract fun setupView()

    abstract fun setUpObservers()

    abstract fun populateData()
}
