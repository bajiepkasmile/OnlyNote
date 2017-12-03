package com.nodomain.onlynote.presentation.mvp.presenterimpls


import android.util.Log
import com.nodomain.onlynote.domain.interactors.GetNotesInteractor
import com.nodomain.onlynote.domain.interactors.GetNotesSuccessEvent
import com.nodomain.onlynote.domain.interactors.RemoveNoteInteractor
import com.nodomain.onlynote.domain.interactors.RemoveNoteSuccessEvent
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.presentation.mvp.presenters.NoteListMvpPresenter
import com.nodomain.onlynote.presentation.mvp.views.NoteListMvpView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject


class NoteListMvpPresenterImpl @Inject constructor(
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
        removeStickyEvent(event)
        Log.e("ETag", event.notes.size.toString())
        mvpView?.showNotes(event.notes)
    }

    @Subscribe
    fun onRemoveNoteSuccess(event: RemoveNoteSuccessEvent) {
        removeStickyEvent(event)
    }
}