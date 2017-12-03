package com.nodomain.onlynote.data.datasources.local


import com.nodomain.onlynote.model.Note


interface LocalStorage {

    fun getNotes(): List<Note>

    fun addNote(note: Note)

    fun removeNote(note: Note)

    fun updateNote(note: Note)
}