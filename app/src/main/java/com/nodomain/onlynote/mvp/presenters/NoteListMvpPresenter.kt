package com.nodomain.onlynote.mvp.presenters


import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.views.NoteListMvpView


interface NoteListMvpPresenter : MvpPresenter<NoteListMvpView> {

    fun getNotes()

    fun getNoteDetails(note: Note)

    fun createNote()

    fun removeNotes(notes: List<Note>)

    fun findNotes(keyStr: String)
}