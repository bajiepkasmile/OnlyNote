package com.nodomain.onlynote.di.modules


import android.content.Context
import android.os.Handler
import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.Executors
import javax.inject.Singleton


@Module
class ApplicationModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideExecutorService() = Executors.newFixedThreadPool(4)

    @Provides
    @Singleton
    fun provideMainThreadHandler() = Handler()

    @Provides
    @Singleton
    fun provideEventBus() = EventBus.getDefault()
}