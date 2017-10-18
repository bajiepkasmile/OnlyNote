package com.nodomain.onlynote.ui.activities


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nodomain.onlynote.domain.interactors.GetNotesInteractor
import com.nodomain.onlynote.domain.interactors.GetNotesSuccessEvent
import org.greenrobot.eventbus.Subscribe
import android.content.Intent
import org.greenrobot.eventbus.EventBus


class SplashActivity : AppCompatActivity() {

    var getNotesInteractor: GetNotesInteractor? = null
    var eventBus: EventBus? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        eventBus?.register(this)
        getNotesInteractor?.execute(null)
    }

    override fun onDestroy() {
        eventBus?.unregister(this)
        super.onDestroy()
    }

    @Subscribe
    fun onGetNotesSuccess(event: GetNotesSuccessEvent) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}