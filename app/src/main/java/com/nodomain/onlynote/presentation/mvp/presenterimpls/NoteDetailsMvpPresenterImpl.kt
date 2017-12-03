package com.nodomain.onlynote.presentation.mvp.presenterimpls


import com.nodomain.onlynote.domain.interactors.*
import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.presentation.mvp.presenters.NoteDetailsMvpPresenter
import com.nodomain.onlynote.presentation.mvp.views.NoteDetailsMvpView
import com.nodomain.onlynote.utils.NoteValidator
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject


class NoteDetailsMvpPresenterImpl @Inject constructor(
        eventBus: EventBus,
        private val createNoteInteractor: CreateNoteInteractor,
        private val updateNoteInteractor: UpdateNoteInteractor,
        private val removeNoteInteractor: RemoveNoteInteractor,
        private val noteValidator: NoteValidator)
    : BaseMvpPresenterImpl<NoteDetailsMvpView>(eventBus), NoteDetailsMvpPresenter {

    private var note: Note? = null

    override fun init(note: Note) {
        this.note = note
        mvpView?.showNote(note)
    }

    override fun saveChanges(newText: String, newAttachments: List<Attachment>) {
        if (note == null)
            saveNewNote(newText, newAttachments)
        else
            saveChangesInOldNote(newText, newAttachments)
    }

    override fun cancelChanges(newText: String, newAttachments: List<Attachment>) {
        if (note == null)
            cancelNewNote(newText, newAttachments)
        else
            cancelChangesInOldNote(newText, newAttachments)
    }

    override fun acceptChangesCancellation() {
        mvpView?.navigateToPreviousView()
    }

    override fun cancelChangesCancellation() {
        //Do nothing
    }

    override fun acceptNoteDeletion() {
        removeNoteInteractor.execute(note!!)
        mvpView?.showProgress()
    }

    override fun cancelNoteDeletion() {
        //Do nothing
    }

    @Subscribe
    fun onAddNoteSuccess(event: AddNoteSuccessEvent) {
        removeStickyEvent(event)
        mvpView?.navigateToPreviousView()
    }

    @Subscribe
    fun onUpdateNoteSuccess(event: UpdateNoteSuccessEvent) {
        removeStickyEvent(event)
        mvpView?.navigateToPreviousView()
    }

    @Subscribe
    fun onRemoveNoteSuccess(event: RemoveNoteSuccessEvent) {
        removeStickyEvent(event)
        mvpView?.navigateToPreviousView()
    }

    private fun saveNewNote(newText: String, newAttachments: List<Attachment>) {
        val dataIsEmpty = noteValidator.checkDataIsEmpty(newText, newAttachments)

        if (dataIsEmpty)
            mvpView?.navigateToPreviousView()
        else {
            createNoteInteractor.execute(AddNoteArgs(newText, newAttachments))
            mvpView?.showProgress()
        }
    }

    private fun saveChangesInOldNote(newText: String, newAttachments: List<Attachment>) {
        val dataIsEmpty = noteValidator.checkDataIsEmpty(newText, newAttachments)
        val dataHasChanged = noteValidator.checkDataHasChanged(note!!, newText, newAttachments)

        when {
            dataIsEmpty -> mvpView?.confirmDeletion()
            dataHasChanged -> {
                updateNoteInteractor.execute(UpdateNoteArgs(note!!, newText, newAttachments))
                mvpView?.showProgress()
            }
            else -> mvpView?.navigateToPreviousView()
        }
    }

    private fun cancelNewNote(newText: String, newAttachments: List<Attachment>) {
        val dataIsEmpty = noteValidator.checkDataIsEmpty(newText, newAttachments)

        if (dataIsEmpty)
            mvpView?.navigateToPreviousView()
        else
            mvpView?.confirmCancellation()
    }

    private fun cancelChangesInOldNote(newText: String, newAttachments: List<Attachment>) {
        val dataHasChanged = noteValidator.checkDataHasChanged(note!!, newText, newAttachments)

        if (dataHasChanged)
            mvpView?.confirmCancellation()
        else
            mvpView?.navigateToPreviousView()
    }
}