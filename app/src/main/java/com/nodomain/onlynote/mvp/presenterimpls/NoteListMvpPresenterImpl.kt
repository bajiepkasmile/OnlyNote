package com.nodomain.onlynote.mvp.presenterimpls


import com.nodomain.onlynote.domain.interactors.GetNotesInteractor
import com.nodomain.onlynote.domain.interactors.GetNotesSuccessEvent
import com.nodomain.onlynote.domain.interactors.RemoveNoteInteractor
import com.nodomain.onlynote.domain.interactors.RemoveNoteSuccessEvent
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.presenters.NoteListMvpPresenter
import com.nodomain.onlynote.mvp.views.NoteListMvpView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class NoteListMvpPresenterImpl(
        eventBus: EventBus,
        private val getNotesInteractor: GetNotesInteractor,
        private val removeNoteInteractor: RemoveNoteInteractor)
    : BaseMvpPresenterImpl<NoteListMvpView>(eventBus), NoteListMvpPresenter {

    override fun getNotes() {
        getNotesInteractor.execute(null)
    }

    override fun getNoteDetails(note: Note) {
        mvpView?.navigateToNoteDetailsView(note)
    }

    override fun createNote() {
        mvpView?.navigateToNoteDetailsView(null)
    }

    override fun removeNote(note: Note) {
        removeNoteInteractor.execute(note)
    }

    override fun findNotes(keyStr: String) {
        TODO("not implemented")
    }

    @Subscribe
    fun onGetNotesSuccess(event: GetNotesSuccessEvent) {
        mvpView?.showNotes(event.notes)
        removeStickyEvent(event)
    }

    @Subscribe
    fun onRemoveNoteSuccess(event: RemoveNoteSuccessEvent) {
        removeStickyEvent(event)
    }
}