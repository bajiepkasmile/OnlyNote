package com.nodomain.onlynote.mvp.presenters


import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.views.NoteDetailsMvpView


interface NoteDetailsMvpPresenter : MvpPresenter<NoteDetailsMvpView> {

    fun addPhoto()

    fun addRecord()

    fun removeAttachment(attachment: Attachment)

    fun createNote(title: String, text: String, attachments: List<Note>)

    fun updateNote(note: Note)
}