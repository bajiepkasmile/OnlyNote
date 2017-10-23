package com.nodomain.onlynote.model


import android.os.Parcel
import android.os.Parcelable


data class Note(
        val id: Long,
        var createdTime: Long,
        var text: String,
        val attachments: List<Attachment>) : Parcelable {

    constructor(source: Parcel) : this(
            source.readLong(),
            source.readLong(),
            source.readString(),
            ArrayList<Attachment>().apply { source.readList(this, Attachment::class.java.classLoader) }
    )

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Note> = object : Parcelable.Creator<Note> {
            override fun createFromParcel(source: Parcel): Note = Note(source)
            override fun newArray(size: Int): Array<Note?> = arrayOfNulls(size)
        }
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeLong(id)
        writeLong(createdTime)
        writeString(text)
        writeList(attachments)
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}