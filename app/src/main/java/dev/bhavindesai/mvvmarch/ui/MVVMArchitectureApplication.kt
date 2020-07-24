package dev.bhavindesai.mvvmarch.ui

import android.app.Application
import dev.bhavindesai.mvvmarch.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree

class MVVMArchitectureApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(DebugTree())

        startKoin {
            androidContext(this@MVVMArchitectureApplication)

            modules(listOf(
                viewModelModule,
                dbModule,
                daoModule,
                repositoryModule,
                networkModule,
                apiServiceModule
            ))
        }
    }
}