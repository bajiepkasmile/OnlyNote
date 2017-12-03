package com.nodomain.onlynote.presentation.mvp.views


import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.presentation.navigation.NoteListNavigator


interface NoteListMvpView : MvpView, NoteListNavigator {

    fun showNotes(notes: MutableList<Note>)
}