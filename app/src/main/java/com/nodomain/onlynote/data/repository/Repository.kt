package com.nodomain.onlynote.data.repository


import com.nodomain.onlynote.data.datasources.DataSourceType
import com.nodomain.onlynote.data.datasources.cache.Cache
import com.nodomain.onlynote.data.datasources.local.LocalStorage
import com.nodomain.onlynote.model.Note


class Repository(val localStorage: LocalStorage, val cache: Cache) {

    val hasCachedNotes: Boolean
        get() = cache.hasNotes

    fun getNotes(dataSourceType: DataSourceType): List<Note> = invokeDependingOnDataSource(
            dataSourceType,
            { getNotes() },
            { notes })

    fun addNote(dataSourceType: DataSourceType, note: Note) = invokeDependingOnDataSource(
            dataSourceType,
            { addNote(note) } ,
            { addNote(note) })

    fun removeNotes(dataSourceType: DataSourceType, notes: List<Note>) = invokeDependingOnDataSource(
            dataSourceType,
            { removeNotes(notes) },
            { removeNotes(notes) })

    fun updateNote(dataSourceType: DataSourceType, oldNote: Note, updatedNote: Note) = invokeDependingOnDataSource(
            dataSourceType,
            { updateNote(oldNote, updatedNote) },
            { updateNote(oldNote, updatedNote) })

    private fun <R> invokeDependingOnDataSource(
            dataSourceType: DataSourceType,
            localStorageFun: LocalStorage.() -> R,
            cacheFun: Cache.() -> R
    ): R = when(dataSourceType) {
        DataSourceType.LOCAL -> localStorage.localStorageFun()
        DataSourceType.CACHE -> cache.cacheFun()
    }
}