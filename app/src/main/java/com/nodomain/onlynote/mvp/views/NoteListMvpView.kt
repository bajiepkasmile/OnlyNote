package com.nodomain.onlynote.mvp.views


import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.navigation.NoteListNavigator


interface NoteListMvpView : MvpView, NoteListNavigator {

    fun showNotes(notes: List<Note>)

    fun showAddedNote(note: Note)
}