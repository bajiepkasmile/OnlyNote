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

    fun removeNote(note: Note) = _notes?.remove(note)

    fun updateNote(note: Note) {
        val index = _notes?.indexOf(note) ?: return

        if (index != -1)
            _notes?.set(index, note)
    }
}