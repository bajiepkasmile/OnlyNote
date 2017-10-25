package data.datasources.local


import com.nodomain.onlynote.data.datasources.local.LocalStorage
import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import javax.inject.Inject


class LocalStorageImpl @Inject constructor() : LocalStorage {

    private val notes = mutableListOf(
            Note(0, 65234554, "Text 1, text 1, text 1, text 1, text 1", emptyList()),
            Note(1, 35234554, "Text 2, text 2, text 2, text 2, text 2", emptyList()),
            Note(2, 53342554, "Text 3, text 3, text 3, text 3, text 3", emptyList())
    )

    private var nextId = 3L

    override fun getNotes(): List<Note> {
        synchronized(this) {
            return notes.toList()
        }
    }

    override fun createNote(createdTime: Long, text: String, attachments: List<Attachment>): Long {
        synchronized(this) {
            val note = Note(nextId, createdTime, text, attachments)
            notes.add(note)
            return nextId++
        }
    }

    override fun removeNote(note: Note) {
        synchronized(this) {
            notes.remove(note)
        }
    }

    override fun updateNote(note: Note) {
        synchronized(this) {
            val index = notes.indexOf(note)
            notes.set(index, note)
        }
    }
}