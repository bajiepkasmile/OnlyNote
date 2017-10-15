package com.nodomain.onlynote.mvp.presenters


import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.views.NoteListMvpView


interface NoteListMvpPresenter : MvpPresenter<NoteListMvpView> {

    fun getNotes()

    fun createNote()

    fun deleteNote(note: Note)

    fun findNotes(keyStr: String)
}