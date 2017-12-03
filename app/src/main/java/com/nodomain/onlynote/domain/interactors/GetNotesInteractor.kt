package com.nodomain.onlynote.domain.interactors


import android.os.Handler
import com.nodomain.onlynote.data.datasources.local.LocalStorage
import com.nodomain.onlynote.model.Note
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.ExecutorService
import javax.inject.Inject


class GetNotesInteractor @Inject constructor(
        executorService: ExecutorService,
        mainThreadHandler: Handler,
        eventBus: EventBus,
        private val localStorage: LocalStorage)
    : BaseInteractor<Void?>(executorService, mainThreadHandler, eventBus) {

    override fun execute(args: Void?) {
        inBackground {
            val notes = localStorage.getNotes()
            onMainThread { postStickyEvent(GetNotesSuccessEvent(notes.toMutableList())) }
        }
    }
}

class GetNotesSuccessEvent(val notes: MutableList<Note>)