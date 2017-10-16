package com.nodomain.onlynote.mvp.presenterimpls


import com.nodomain.onlynote.domain.interactors.*
import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.presenters.NoteDetailsMvpPresenter
import com.nodomain.onlynote.mvp.views.NoteDetailsMvpView
import org.greenrobot.eventbus.Subscribe


class NoteDetailsMvpPresenterImpl(
        private val addNoteInteractor: AddNoteInteractor,
        private val updateNoteInteractor: UpdateNoteInteractor) : NoteDetailsMvpPresenter {

    override lateinit var mvpView: NoteDetailsMvpView
    private var note: Note? = null

    override fun init(note: Note) {
        this.note = note
        mvpView.showNote(note)
    }

    override fun finishEditing(newText: String, newAttachments: List<Attachment>) {
        if (note == null) {
            val dataIsNotEmpty = !checkDataIsEmpty(newText, newAttachments)

            if (dataIsNotEmpty) {
                addNoteInteractor.execute(AddNoteArgs(newText, newAttachments))
                mvpView.showProgress()
            } else
                mvpView.navigateToPreviousView()
        } else {
            val dataHasChanged = checkDataHasChanged(newText, newAttachments)

            if (dataHasChanged)
                mvpView.confirmChanges()
            else
                mvpView.navigateToPreviousView()
        }
    }

    override fun saveChanges(newText: String, newAttachments: List<Attachment>) {
        updateNoteInteractor.execute(UpdateNoteArgs(note!!, newText, newAttachments))
        mvpView.showProgress()
    }

    @Subscribe
    fun onAddNoteSuccess(event: AddNoteSuccessEvent) {
        mvpView.navigateToPreviousView()
    }

    @Subscribe
    fun onUpdateNoteSuccess(event: UpdateNoteSuccessEvent) {
        mvpView.navigateToPreviousView()
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