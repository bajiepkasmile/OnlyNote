package com.nodomain.onlynote.mvp.presenterimpls


import com.nodomain.onlynote.domain.interactors.*
import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.presenters.NoteDetailsMvpPresenter
import com.nodomain.onlynote.mvp.views.NoteDetailsMvpView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class NoteDetailsMvpPresenterImpl(
        eventBus: EventBus,
        private val addNoteInteractor: AddNoteInteractor,
        private val updateNoteInteractor: UpdateNoteInteractor)
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

    @Subscribe
    fun onAddNoteSuccess(event: AddNoteSuccessEvent) {
        mvpView?.navigateToPreviousView()
    }

    @Subscribe
    fun onUpdateNoteSuccess(event: UpdateNoteSuccessEvent) {
        mvpView?.navigateToPreviousView()
    }

    private fun saveNewNote(newText: String, newAttachments: List<Attachment>) {
        val dataIsEmpty = checkDataIsEmpty(newText, newAttachments)

        if (dataIsEmpty)
            mvpView?.navigateToPreviousView()
        else {
            addNoteInteractor.execute(AddNoteArgs(newText, newAttachments))
            mvpView?.showProgress()
        }
    }

    private fun saveChangesInOldNote(newText: String, newAttachments: List<Attachment>) {
        val dataIsEmpty = checkDataIsEmpty(newText, newAttachments)
        val dataHasChanged = checkDataHasChanged(newText, newAttachments)

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
        val dataIsEmpty = checkDataIsEmpty(newText, newAttachments)

        if (dataIsEmpty)
            mvpView?.navigateToPreviousView()
        else
            mvpView?.confirmCancellation()
    }

    private fun cancelChangesInOldNote(newText: String, newAttachments: List<Attachment>) {
        val dataHasChanged = checkDataHasChanged(newText, newAttachments)

        if (dataHasChanged)
            mvpView?.confirmCancellation()
        else
            mvpView?.navigateToPreviousView()
    }

    private fun checkDataIsEmpty(text: String, attachments: List<Attachment>): Boolean {
        return text.isEmpty() && attachments.isEmpty()
    }

    private fun checkDataHasChanged(text: String, attachments: List<Attachment>): Boolean {
        if (text != note?.text) return true
        if (checkAttachmentsHaveChanged(attachments)) return true
        return false
    }

    private fun checkAttachmentsHaveChanged(attachments: List<Attachment>): Boolean {
        if (attachments.size != note?.attachments?.size) return true
        return note!!.attachments.none { attachments.contains(it) }
    }
}