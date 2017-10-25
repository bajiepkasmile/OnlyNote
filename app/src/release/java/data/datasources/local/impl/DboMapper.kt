package com.nodomain.onlynote.data.datasources.local.impl


import com.nodomain.onlynote.model.Note


fun Note.toDbo() = NoteDbo(0, createdTime, text, attachments)

fun List<Note>.toDbo() = map { it.toDbo() }

fun NoteDbo.fromDbo() = Note(_id!!, createdTime, text, attachments)

fun List<NoteDbo>.fromDbo() = map { it.fromDbo() }