package com.nodomain.onlynote.presentation.navigation


import com.nodomain.onlynote.model.Note


interface NoteListNavigator {

    fun navigateToNoteDetailsView(note: Note?)
}