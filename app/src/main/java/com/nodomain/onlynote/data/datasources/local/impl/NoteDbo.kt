package com.nodomain.onlynote.data.datasources.local.impl


import com.nodomain.onlynote.model.Attachment
import nl.qbusict.cupboard.annotation.Column


data class NoteDbo(
        val _id: Long?,
        @Column("created_time") val createdTime: Long,
        val text: String,
        val attachments: List<Attachment>)