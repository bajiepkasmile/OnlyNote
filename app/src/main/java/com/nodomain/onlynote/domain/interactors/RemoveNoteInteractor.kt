package com.nodomain.onlynote.domain.interactors


import android.os.Handler
import com.nodomain.onlynote.data.datasources.DataSourceType
import com.nodomain.onlynote.data.repository.Repository
import com.nodomain.onlynote.model.Note
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.ExecutorService


class RemoveNoteInteractor(
        executorService: ExecutorService,
        mainThreadHandler: Handler,
        eventBus: EventBus,
        private val repository: Repository) : BaseInteractor<Note>(executorService, mainThreadHandler, eventBus) {

    override fun execute(args: Note) {
        repository.removeNotes(DataSourceType.CACHE, args)

        inBackground {
            repository.removeNotes(DataSourceType.LOCAL, args)
            onMainThread { postStickyEvent(RemoveNoteSuccessEvent(args)) }
        }
    }
}

class RemoveNoteSuccessEvent(val removedNote: Note)