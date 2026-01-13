package com.johnkenedy.imageloadingnavigation.app

import android.app.Application
import com.johnkenedy.imageloadingnavigation.gallery.di.destinationsModule
import org.koin.core.context.startKoin

class DestinationsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                destinationsModule
            )
        }
    }

}