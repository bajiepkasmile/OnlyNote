package com.nodomain.onlynote.domain.interactors


import android.os.Handler
import com.nodomain.onlynote.data.datasources.DataSourceType
import com.nodomain.onlynote.data.repository.Repository
import com.nodomain.onlynote.domain.events.AddNoteSuccessEvent
import com.nodomain.onlynote.model.Note
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.ExecutorService


class AddNoteInteractor(
        executorService: ExecutorService,
        mainThreadHandler: Handler,
        eventBus: EventBus,
        private val repository: Repository) : BaseInteractor<Note>(executorService, mainThreadHandler, eventBus) {

    override fun execute(note: Note) {
        repository.addNote(DataSourceType.CACHE, note)

        inBackground {
            repository.addNote(DataSourceType.LOCAL, note)
            onMainThread { postStickyEvent(AddNoteSuccessEvent(note)) }
        }
    }
}