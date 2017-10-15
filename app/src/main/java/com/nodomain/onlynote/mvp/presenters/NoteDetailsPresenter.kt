package com.nodomain.onlynote.mvp.presenters


import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note


interface NoteDetailsPresenter {

    fun addPhoto()

    fun addRecord()

    fun removeAttachment(attachment: Attachment)

    fun createNote(title: String, text: String, attachments: List<Note>)

    fun updateNote(note: Note)
}