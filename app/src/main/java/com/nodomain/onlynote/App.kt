package com.nodomain.onlynote


import android.app.Application
import com.nodomain.onlynote.di.components.DaggerApplicationComponent
import com.nodomain.onlynote.di.modules.ApplicationModule


class App : Application() {

    val applicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()

//      The code defined by the property won’t be executed until component.inject (this) is done,
//      so that by that time this already exists and can be created securely way.
        applicationComponent.inject(this)
    }
}