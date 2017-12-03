package com.nodomain.onlynote.presentation.mvp.views


import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.presentation.navigation.NoteDetailsNavigator


interface NoteDetailsMvpView : MvpView, NoteDetailsNavigator {

    fun showNote(note: Note)

    fun confirmCancellation()

    fun confirmDeletion()

    fun showProgress()
}