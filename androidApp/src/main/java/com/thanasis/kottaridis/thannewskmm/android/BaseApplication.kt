package com.thanasis.kottaridis.thannewskmm.android

import android.app.Application
import com.thanasis.kottaridis.thannewskmm.android.di.viewModelsModule
import com.thanasis.kottaridis.thannewskmm.core.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// This is the first class that is beeing instantiate when we launch the application
// it is a signleton and stay alive until user kill the application.
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // here we have to initialize Koin.
        initKoin()
    }

    private fun initKoin() {
        // 1. collect all modules that we want to instantiate.
        val modules = sharedKoinModules + viewModelsModule

        // 2. start koin by providing context and all target modules
        startKoin {
            androidContext(this@BaseApplication)
            modules(modules)
        }
    }
}
