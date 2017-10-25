package com.nodomain.onlynote.ui.activities


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nodomain.onlynote.R
import com.nodomain.onlynote.navigation.MainNavigator
import android.app.Activity
import com.nodomain.onlynote.di.modules.MainActivityModule
import com.nodomain.onlynote.App


class MainActivity : AppCompatActivity() {

    private val Activity.app: App
        get() = application as App

    val mainActivitySubComponent by lazy {
        app.applicationComponent.plusMainActivitySubComponent(MainActivityModule(navigator))
    }

    private val navigator: MainNavigator = MainNavigator(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivitySubComponent.inject(this)

        if (savedInstanceState == null)
            navigator.navigateToNoteList()
    }
}