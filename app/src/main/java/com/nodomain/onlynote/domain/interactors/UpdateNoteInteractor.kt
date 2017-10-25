package com.nodomain.onlynote.domain.interactors


import android.os.Handler
import com.nodomain.onlynote.data.repository.Repository
import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.utils.TimeUtil
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.ExecutorService
import javax.inject.Inject


class UpdateNoteInteractor @Inject constructor(
        executorService: ExecutorService,
        mainThreadHandler: Handler,
        eventBus: EventBus,
        private val repository: Repository,
        private val timeUtil: TimeUtil)
    : BaseInteractor<UpdateNoteArgs>(executorService, mainThreadHandler, eventBus) {

    override fun execute(args: UpdateNoteArgs) {
        inBackground {
            val updatedNote = Note(args.oldNote.id, timeUtil.currentTime, args.newText, args.newAttachments)
            repository.updateNote(updatedNote)
            onMainThread { postStickyEvent(UpdateNoteSuccessEvent(updatedNote)) }
        }
    }
}

class UpdateNoteArgs(
        val oldNote: Note,
        val newText: String,
        val newAttachments: List<Attachment>)

class UpdateNoteSuccessEvent(val updatedNote: Note)