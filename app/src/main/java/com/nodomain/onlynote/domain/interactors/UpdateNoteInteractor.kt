package com.nodomain.onlynote.domain.interactors


import android.os.Handler
import com.nodomain.onlynote.data.datasources.DataSourceType
import com.nodomain.onlynote.data.repository.Repository
import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.utils.TimeUtil
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.ExecutorService


class UpdateNoteInteractor(
        executorService: ExecutorService,
        mainThreadHandler: Handler,
        eventBus: EventBus,
        private val repository: Repository,
        private val timeUtil: TimeUtil)
    : BaseInteractor<UpdateNoteArgs>(executorService, mainThreadHandler, eventBus) {

    override fun execute(args: UpdateNoteArgs) {
        val updatedNote = Note(timeUtil.currentTime, args.newText, args.newAttachments)

        repository.updateNote(DataSourceType.CACHE, args.oldNote, updatedNote)

        inBackground {
            repository.updateNote(DataSourceType.LOCAL, args.oldNote, updatedNote)
            onMainThread { postStickyEvent(UpdateNoteSuccessEvent(args.oldNote, updatedNote)) }
        }
    }
}

class UpdateNoteArgs(
        val oldNote: Note,
        val newText: String,
        val newAttachments: List<Attachment>)

class UpdateNoteSuccessEvent(val oldNote: Note, val updatedNote: Note)