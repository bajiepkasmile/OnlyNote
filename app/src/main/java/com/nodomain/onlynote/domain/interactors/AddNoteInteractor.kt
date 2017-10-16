package com.nodomain.onlynote.domain.interactors


import android.os.Handler
import com.nodomain.onlynote.data.datasources.DataSourceType
import com.nodomain.onlynote.data.repository.Repository
import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.utils.TimeUtil
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.ExecutorService


class AddNoteInteractor(
        executorService: ExecutorService,
        mainThreadHandler: Handler,
        eventBus: EventBus,
        private val repository: Repository,
        private val timeUtil: TimeUtil)
    : BaseInteractor<AddNoteArgs>(executorService, mainThreadHandler, eventBus) {

    override fun execute(args: AddNoteArgs) {
        val newNote = Note(timeUtil.currentTime, args.text, args.attachments)
        repository.addNote(DataSourceType.CACHE, newNote)

        inBackground {
            repository.addNote(DataSourceType.LOCAL, newNote)
            onMainThread { postStickyEvent(AddNoteSuccessEvent(newNote)) }
        }
    }
}

class AddNoteArgs(
        val text: String,
        val attachments: List<Attachment>)

class AddNoteSuccessEvent(val addedNote: Note)