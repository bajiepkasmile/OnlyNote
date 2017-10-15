package com.nodomain.onlynote.domain.interactors


import android.os.Handler
import com.nodomain.onlynote.data.datasources.DataSourceType
import com.nodomain.onlynote.data.repository.Repository
import com.nodomain.onlynote.domain.events.UpdateNoteSuccessEvent
import com.nodomain.onlynote.model.Note
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.ExecutorService


class UpdateNoteInteractor(
        executorService: ExecutorService,
        mainThreadHandler: Handler,
        eventBus: EventBus,
        private val repository: Repository) : BaseInteractor<Note>(executorService, mainThreadHandler, eventBus) {

    override fun execute(note: Note) {
        repository.updateNote(DataSourceType.CACHE, note)

        inBackground {
            repository.updateNote(DataSourceType.LOCAL, note)
            onMainThread { postStickyEvent(UpdateNoteSuccessEvent(note)) }
        }
    }
}