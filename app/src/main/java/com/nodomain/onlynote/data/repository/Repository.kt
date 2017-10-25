package com.nodomain.onlynote.data.repository


import com.nodomain.onlynote.data.datasources.DataSourceType
import com.nodomain.onlynote.data.datasources.cache.Cache
import com.nodomain.onlynote.data.datasources.local.LocalStorage
import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import javax.inject.Inject


class Repository @Inject constructor(
        private val localStorage: LocalStorage,
        private val cache: Cache) {

    val hasCachedNotes: Boolean
        get() = cache.hasNotes

    fun getNotes(dataSourceType: DataSourceType): List<Note> = when(dataSourceType) {
        DataSourceType.LOCAL -> localStorage.getNotes()
        DataSourceType.CACHE -> cache.notes
    }

    fun createNote(createdTime: Long, text: String, attachments: List<Attachment>): Note {
        val noteId = localStorage.createNote(createdTime, text, attachments)
        val createdNote = Note(noteId, createdTime, text, attachments)
        cache.addNote(createdNote)
        return createdNote
    }

    fun removeNote(note: Note) {
        localStorage.removeNote(note)
        cache.removeNote(note)
    }

    fun updateNote(note: Note) {
        localStorage.updateNote(note)
        cache.updateNote(note)
    }
}