package com.nodomain.onlynote.mvp.presenters


import com.nodomain.onlynote.model.Note


interface NoteListPresenter {

    fun getNotes()

    fun createNote()

    fun deleteNote(note: Note)

    fun findNotes(keyStr: String)
}