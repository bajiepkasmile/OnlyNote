package com.nodomain.onlynote.di.components


import com.nodomain.onlynote.App
import com.nodomain.onlynote.di.modules.ApplicationModule
import com.nodomain.onlynote.di.modules.DataSourcesModule
import com.nodomain.onlynote.di.modules.MainActivityModule
import com.nodomain.onlynote.ui.activities.SplashActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
        modules = arrayOf(
            ApplicationModule::class,
            DataSourcesModule::class
        )
)
interface ApplicationComponent {

    fun plusMainActivitySubComponent(module: MainActivityModule): MainActivitySubComponent

    fun inject(app: App)

    fun inject(activity: SplashActivity)
}