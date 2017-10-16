package com.nodomain.onlynote.mvp.views


import com.nodomain.onlynote.model.Note


interface NoteDetailsMvpView : MvpView {

    fun showNote(note: Note)

    fun confirmChanges()

    fun showProgress()

    fun navigateToPreviousView()
}