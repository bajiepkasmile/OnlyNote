package com.nodomain.onlynote.data.datasources.local


import com.nodomain.onlynote.model.Note
import javax.inject.Inject


class LocalStorageImpl @Inject constructor(): LocalStorage {

    override fun getNotes(): List<Note> {
        TODO("not implemented")
    }

    override fun addNote(note: Note) {
        TODO("not implemented")
    }

    override fun removeNote(note: Note) {
        TODO("not implemented")
    }

    override fun updateNote(note: Note) {
        TODO("not implemented")
    }
}