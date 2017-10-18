package com.nodomain.onlynote.ui.activities


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nodomain.onlynote.R
import com.nodomain.onlynote.navigation.MainNavigator


class MainActivity : AppCompatActivity() {

    val navigator: MainNavigator = MainNavigator(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            navigator.navigateToNoteList()
    }
}