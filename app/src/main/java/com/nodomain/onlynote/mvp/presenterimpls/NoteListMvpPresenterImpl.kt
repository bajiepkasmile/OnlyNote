package com.nodomain.onlynote.mvp.presenterimpls


import com.nodomain.onlynote.domain.interactors.GetNotesInteractor
import com.nodomain.onlynote.domain.interactors.RemoveNotesInteractor
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.presenters.NoteListMvpPresenter
import com.nodomain.onlynote.mvp.views.NoteListMvpView


class NoteListMvpPresenterImpl(
        private val getNotesInteractor: GetNotesInteractor,
        private val removeNotesInteractor: RemoveNotesInteractor) : NoteListMvpPresenter {

    override lateinit var mvpView: NoteListMvpView

    override fun getNotes() {
        getNotesInteractor.execute(null)
    }

    override fun getNoteDetails(note: Note) {
        mvpView.navigateToNoteDetailsView(note)
    }

    override fun createNote() {
        mvpView.navigateToNoteDetailsView(null)
    }

    override fun removeNotes(notes: List<Note>) {
        removeNotesInteractor.execute(notes)
    }

    override fun findNotes(keyStr: String) {

    }
}