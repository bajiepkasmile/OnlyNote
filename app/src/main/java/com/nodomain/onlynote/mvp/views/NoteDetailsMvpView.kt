package com.nodomain.onlynote.mvp.views


import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.navigation.NoteDetailsNavigator


interface NoteDetailsMvpView : MvpView, NoteDetailsNavigator {

    fun showNote(note: Note)

    fun confirmCancellation()

    fun confirmDeletion()

    fun showProgress()
}