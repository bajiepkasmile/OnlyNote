package com.nodomain.onlynote.mvp.views


import com.nodomain.onlynote.model.Note


interface NoteListMvpView : MvpView {

    fun showNotes(notes: List<Note>)

    fun showAddedNote(note: Note)

    fun navigateToNoteDetailsView(note: Note?)
}