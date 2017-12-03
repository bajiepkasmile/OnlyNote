package com.nodomain.onlynote.presentation.mvp.presenters


import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.presentation.mvp.views.NoteDetailsMvpView


interface NoteDetailsMvpPresenter : MvpPresenter<NoteDetailsMvpView> {

    fun init(note: Note)

    fun saveChanges(newText: String, newAttachments: List<Attachment>)

    fun cancelChanges(newText: String, newAttachments: List<Attachment>)

    fun acceptChangesCancellation()

    fun cancelChangesCancellation()

    fun acceptNoteDeletion()

    fun cancelNoteDeletion()
}