package com.nodomain.onlynote.model


data class Note(
        var createdTime: Long,
        var text: String,
        val attachments: List<Attachment>)