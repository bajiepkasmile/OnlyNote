package com.nodomain.onlynote.model


data class Note(
        var title: String,
        var text: String,
        val attachments: List<Attachment>)