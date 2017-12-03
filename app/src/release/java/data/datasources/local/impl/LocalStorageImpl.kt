package data.datasources.local.impl


import com.nodomain.onlynote.data.datasources.local.LocalStorage
import com.nodomain.onlynote.model.Note
import javax.inject.Inject


class LocalStorageImpl @Inject constructor() : LocalStorage {

    override fun getNotes(): List<Note> {
        TODO()
    }

    override fun addNote(note: Note) {
        TODO()
    }

    override fun removeNote(note: Note) {
        TODO()
    }

    override fun updateNote(note: Note) {
        TODO()
    }
}