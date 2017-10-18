package com.nodomain.onlynote.mvp.presenterimpls


import com.nodomain.onlynote.domain.interactors.GetNotesInteractor
import com.nodomain.onlynote.domain.interactors.GetNotesSuccessEvent
import com.nodomain.onlynote.domain.interactors.RemoveNotesInteractor
import com.nodomain.onlynote.domain.interactors.RemoveNotesSuccessEvent
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.presenters.NoteListMvpPresenter
import com.nodomain.onlynote.mvp.views.NoteListMvpView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class NoteListMvpPresenterImpl(
        eventBus: EventBus,
        private val getNotesInteractor: GetNotesInteractor,
        private val removeNotesInteractor: RemoveNotesInteractor)
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

    //TODO: change to removeNote(note: Note)
    override fun removeNotes(notes: List<Note>) {
        removeNotesInteractor.execute(notes)
    }

    override fun findNotes(keyStr: String) {
        TODO()
    }

    @Subscribe
    fun onGetNotesSuccess(event: GetNotesSuccessEvent) {
        mvpView?.showNotes(event.notes)
    }

    @Subscribe
    fun onRemoveNotesSuccess(event: RemoveNotesSuccessEvent) {

    }
}