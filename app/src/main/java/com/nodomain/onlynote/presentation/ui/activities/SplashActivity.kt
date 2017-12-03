package com.nodomain.onlynote.presentation.ui.activities


import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nodomain.onlynote.domain.interactors.GetNotesInteractor
import com.nodomain.onlynote.domain.interactors.GetNotesSuccessEvent
import org.greenrobot.eventbus.Subscribe
import android.content.Intent
import com.nodomain.onlynote.App
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject


class SplashActivity : AppCompatActivity() {

    private val Activity.app: App
        get() = application as App

    @Inject
    lateinit var getNotesInteractor: GetNotesInteractor
    @Inject
    lateinit var eventBus: EventBus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.applicationComponent.inject(this)

        //Need to do this in advance to load the notes from db into the cache
        eventBus.register(this)
        getNotesInteractor.execute(null)
    }

    override fun onDestroy() {
        eventBus.unregister(this)
        super.onDestroy()
    }

    @Subscribe
    fun onGetNotesSuccess(event: GetNotesSuccessEvent) {
        eventBus.removeStickyEvent(event)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}