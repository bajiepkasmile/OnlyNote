package com.nodomain.onlynote.data.datasources.local


import com.nodomain.onlynote.data.datasources.local.impl.DbHelper
import com.nodomain.onlynote.data.datasources.local.impl.NoteDbo
import com.nodomain.onlynote.data.datasources.local.impl.fromDbo
import com.nodomain.onlynote.data.datasources.local.impl.toDbo
import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note
import nl.qbusict.cupboard.CupboardFactory.cupboard


class LocalStorage(private val dbHelper: DbHelper) {

    fun getNotes(): List<Note> {
        val db = dbHelper.readableDatabase
        val noteDbos = cupboard().withDatabase(db).query(NoteDbo::class.java).list()
        return noteDbos.fromDbo()
    }

    fun createNote(createdTime: Long, text: String, attachments: List<Attachment>): Long {
        val noteDbo = NoteDbo(null, createdTime, text, attachments)
        val db = dbHelper.writableDatabase
        return cupboard().withDatabase(db).put(noteDbo)
    }

    fun removeNote(note: Note) {
        val db = dbHelper.writableDatabase
        cupboard().withDatabase(db).delete(note.toDbo())
    }

    fun updateNote(note: Note) {
        val db = dbHelper.writableDatabase
        cupboard().withDatabase(db).put(note.toDbo())
    }
}