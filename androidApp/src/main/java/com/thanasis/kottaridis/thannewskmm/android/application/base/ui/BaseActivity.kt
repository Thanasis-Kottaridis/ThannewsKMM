package com.thanasis.kottaridis.thannewskmm.android.application.base.ui

import android.graphics.PorterDuff
import android.view.ViewGroup
import android.view.ViewGroup.GONE
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.VISIBLE
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.thanasis.kottaridis.thannewskmm.android.R

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var container: RelativeLayout
    private lateinit var progressBar: ProgressBar

    fun setUpLoaderView(binding: ViewBinding) {
        // Create a container view (e.g., FrameLayout)
        container = RelativeLayout(this)

        // Set container view attributes (optional)
        container.layoutParams =
            LayoutParams(
                LayoutParams.MATCH_PARENT, // Width
                LayoutParams.MATCH_PARENT, // Height
            )
        container.setBackgroundColor(resources.getColor(R.color.effect_shadow)) // Set background color

        // Create a ProgressBar
        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleLarge)
        progressBar.indeterminateDrawable.setColorFilter(
            resources.getColor(R.color.brand_primary),
            PorterDuff.Mode.SRC_IN,
        )
        // Set ProgressBar attributes (optional)
        progressBar.isIndeterminate = true // You can change this as needed

        val progressBarLayoutParams =
            RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, // Width
                LayoutParams.WRAP_CONTENT, // Height
            )
        progressBarLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        progressBar.layoutParams = progressBarLayoutParams

        // Add the ProgressBar to the container
        container.addView(progressBar)

        // Set the container as the activity's content view
        (binding.root as? ViewGroup)?.addView(container)

        // set loader hidden
        hideLoader()
    }

    open fun showLoader() {
        container.bringToFront()
        container.visibility = VISIBLE
        progressBar.visibility = VISIBLE
        container.isClickable = true
        container.isFocusable = true
    }

    open fun hideLoader() {
        container.visibility = GONE
        progressBar.visibility = GONE
        container.isClickable = false
        container.isFocusable = false
    }
}
