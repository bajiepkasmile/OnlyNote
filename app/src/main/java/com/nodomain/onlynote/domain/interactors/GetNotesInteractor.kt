package com.nodomain.onlynote.domain.interactors


import android.os.Handler
import com.nodomain.onlynote.data.datasources.DataSourceType
import com.nodomain.onlynote.data.repository.Repository
import com.nodomain.onlynote.model.Note
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.ExecutorService


class GetNotesInteractor(
        executorService: ExecutorService,
        mainThreadHandler: Handler,
        eventBus: EventBus,
        private val repository: Repository) : BaseInteractor<Void?>(executorService, mainThreadHandler, eventBus) {

    override fun execute(args: Void?) {
        if (repository.hasCachedNotes) {
            val notes = repository.getNotes(DataSourceType.CACHE)
            postStickyEvent(GetNotesSuccessEvent(notes.toMutableList()))
            return
        }

        inBackground {
            val notes = repository.getNotes(DataSourceType.LOCAL)
            onMainThread { postStickyEvent(GetNotesSuccessEvent(notes.toMutableList())) }
        }
    }
}

class GetNotesSuccessEvent(val notes: MutableList<Note>)