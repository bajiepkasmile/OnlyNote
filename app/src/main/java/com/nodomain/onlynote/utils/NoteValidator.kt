package com.nodomain.onlynote.utils

import com.nodomain.onlynote.model.Attachment
import com.nodomain.onlynote.model.Note


class NoteValidator {

    fun checkDataIsEmpty(text: String, attachments: List<Attachment>)
            = text.isEmpty() && attachments.isEmpty()

    fun checkDataHasChanged(note: Note, newText: String, newAttachments: List<Attachment>): Boolean {
        if (newText != note.text) return true
        if (checkAttachmentsHaveChanged(note.attachments, newAttachments)) return true
        return false
    }

    private fun checkAttachmentsHaveChanged(oldAttachments: List<Attachment>, newAttachments: List<Attachment>): Boolean {
        if (oldAttachments.size != newAttachments.size) return true
        return newAttachments.none { oldAttachments.contains(it) }
    }
}