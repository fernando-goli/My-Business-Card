package com.fgomes.mybusinesscard

import android.app.Application
import com.fgomes.mybusinesscard.di.db
import com.fgomes.mybusinesscard.di.domainModule
import com.fgomes.mybusinesscard.di.repositoryModule
import com.fgomes.mybusinesscard.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(viewModelModule)
            modules(repositoryModule)
            modules(db)
            modules(domainModule)
        }
    }
}