package com.nodomain.onlynote.ui.activities


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nodomain.onlynote.domain.interactors.GetNotesInteractor
import com.nodomain.onlynote.domain.interactors.GetNotesSuccessEvent
import org.greenrobot.eventbus.Subscribe
import android.content.Intent


class SplashActivity : AppCompatActivity() {

    var getNotesInteractor: GetNotesInteractor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getNotesInteractor?.execute(null)
    }

    @Subscribe
    fun onGetNotesSuccess(event: GetNotesSuccessEvent) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}