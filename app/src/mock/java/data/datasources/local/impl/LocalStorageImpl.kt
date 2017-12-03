package data.datasources.local


import com.nodomain.onlynote.data.datasources.local.LocalStorage
import com.nodomain.onlynote.model.Note
import java.util.concurrent.CopyOnWriteArrayList
import javax.inject.Inject


class LocalStorageImpl @Inject constructor() : LocalStorage {

    private val notes = CopyOnWriteArrayList(NoteGenerator().generateNotes(3))

    override fun getNotes() = notes.toList()

    override fun addNote(note: Note) {
        notes.add(note)
    }

    override fun removeNote(note: Note) {
        notes.remove(note)
    }

    override fun updateNote(note: Note) {
        val index = notes.indexOf(note)
        notes[index] = note
    }
}