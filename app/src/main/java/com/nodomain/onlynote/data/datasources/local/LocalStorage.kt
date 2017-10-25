package com.nodomain.onlynote.data.datasources.local


import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note


interface LocalStorage {

    fun getNotes(): List<Note>

    fun createNote(createdTime: Long, text: String, attachments: List<Attachment>): Long

    fun removeNote(note: Note)

    fun updateNote(note: Note)
}