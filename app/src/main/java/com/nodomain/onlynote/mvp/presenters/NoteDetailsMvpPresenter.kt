package com.nodomain.onlynote.mvp.presenters


import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.views.NoteDetailsMvpView


interface NoteDetailsMvpPresenter : MvpPresenter<NoteDetailsMvpView> {

    fun init(note: Note)

    fun finishEditing(newText: String, newAttachments: List<Attachment>)

    fun saveChanges(newText: String, newAttachments: List<Attachment>)
}