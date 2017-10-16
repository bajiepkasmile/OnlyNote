package com.nodomain.onlynote.navigation


import com.nodomain.onlynote.model.Note


interface NoteListNavigator {

    fun navigateToNoteDetailsView(note: Note?)
}