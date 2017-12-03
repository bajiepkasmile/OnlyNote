package com.nodomain.onlynote.model


import android.os.Parcel
import android.os.Parcelable
import java.util.*


data class Note(
        var createdDate: Date,
        var text: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            Date(parcel.readLong()),
            parcel.readString())

    companion object CREATOR : Parcelable.Creator<Note> {

        override fun createFromParcel(parcel: Parcel) = Note(parcel)

        override fun newArray(size: Int): Array<Note?> = arrayOfNulls(size)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(createdDate.time)
        parcel.writeString(text)
    }

    override fun describeContents() = 0

    override fun hashCode(): Int = createdDate.hashCode()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Note
        return createdDate == other.createdDate
    }
}