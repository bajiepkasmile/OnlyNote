package com.nodomain.onlynote.data.datasources.cache


import com.nodomain.onlynote.model.Note


class Cache {

    private var _notes: MutableList<Note>? = null

    var notes: List<Note>
        get() {
            synchronized(this) {
                return _notes?.toList() ?: emptyList()
            }
        }

        set(value) {
            synchronized(this) {
                _notes = value.toMutableList()
            }
        }

    val hasNotes: Boolean
        get() {
            synchronized(this) {
                return _notes != null
            }
        }

    fun addNote(note: Note) {
        synchronized(this) {
            if (_notes == null)
                _notes = ArrayList()
            _notes?.add(note)
        }
    }

    fun removeNote(note: Note) {
        synchronized(this) {
            _notes?.remove(note)
        }
    }

    fun updateNote(updatedNote: Note) {
        synchronized(this) {
            val index = _notes?.indexOf(updatedNote) ?: return

            if (index != -1)
                _notes?.set(index, updatedNote)
        }
    }
}