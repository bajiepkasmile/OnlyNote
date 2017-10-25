package com.nodomain.onlynote.domain.interactors


import android.os.Handler
import com.nodomain.onlynote.data.repository.Repository
import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.utils.TimeUtil
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.ExecutorService
import javax.inject.Inject


class CreateNoteInteractor @Inject constructor(
        executorService: ExecutorService,
        mainThreadHandler: Handler,
        eventBus: EventBus,
        private val repository: Repository,
        private val timeUtil: TimeUtil)
    : BaseInteractor<AddNoteArgs>(executorService, mainThreadHandler, eventBus) {

    override fun execute(args: AddNoteArgs) {
        inBackground {
            val newNote = repository.createNote(timeUtil.currentTime, args.text, args.attachments)
            onMainThread { postStickyEvent(AddNoteSuccessEvent(newNote)) }
        }
    }
}

class AddNoteArgs(
        val text: String,
        val attachments: List<Attachment>)

class AddNoteSuccessEvent(val addedNote: Note)