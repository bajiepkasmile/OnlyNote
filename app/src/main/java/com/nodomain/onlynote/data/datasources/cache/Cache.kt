package com.nodomain.onlynote.data.datasources.cache


import com.nodomain.onlynote.model.Note


class Cache {

    private var _notes: MutableList<Note>? = null

    var notes: List<Note>
        get() = _notes?.toList() ?: emptyList()

        set(value) {
            _notes = value.toMutableList()
        }

    val hasNotes: Boolean
        get() = _notes != null

    fun addNote(note: Note) {
        if (_notes == null)
            _notes = ArrayList()
        _notes?.add(note)
    }

    fun removeNotes(notes: List<Note>) = _notes?.removeAll(notes)

    fun updateNote(oldNote: Note, updatedNote: Note) {
        val index = _notes?.indexOf(oldNote) ?: return

        if (index != -1)
            _notes?.set(index, updatedNote)
    }
}