package com.recipe.app

import android.app.Application
import com.recipe.app.di.FakeApiModule
import com.recipe.core.di.DatabaseModule
import com.recipe.core.di.NetworkModule
import com.recipe.core.di.RepositoryModule
import com.recipe.feature.di.UseCasesModule
import com.recipe.feature.di.ViewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                FakeApiModule,
                NetworkModule,
                DatabaseModule,
                RepositoryModule,
                UseCasesModule,
                ViewModelsModule
            )
        }
    }
}