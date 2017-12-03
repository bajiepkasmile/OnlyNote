package com.nodomain.onlynote.presentation.mvp.presenters


import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.presentation.mvp.views.NoteListMvpView


interface NoteListMvpPresenter : MvpPresenter<NoteListMvpView> {

    fun getNotes()

    fun getNoteDetails(note: Note)

    fun createNote()

    fun removeNote(note: Note)

    fun findNotes(keyStr: String)
}