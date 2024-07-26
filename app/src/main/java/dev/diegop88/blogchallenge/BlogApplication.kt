package dev.diegop88.blogchallenge

import android.app.Application
import dev.diegop88.blogchallenge.di.blogModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BlogApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BlogApplication)
            modules(blogModule)
        }
    }
}
