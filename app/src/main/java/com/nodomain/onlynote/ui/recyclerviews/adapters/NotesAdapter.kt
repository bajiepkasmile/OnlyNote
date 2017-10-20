package com.nodomain.onlynote.ui.recyclerviews.adapters


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nodomain.onlynote.R
import com.nodomain.onlynote.model.AttachmentType
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.ui.recyclerviews.viewholders.NoteViewHolder


class NotesAdapter(private var notes: MutableList<Note>) : RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater
                .from(parent!!.context)
                .inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder?, position: Int) {
        val note = notes[position]

        holder?.tvText?.text = note.text
        holder?.tvCreatedTime?.text = note.createdTime.toString()
        holder?.tvPhotoAttachmentsCount?.text =
                note.attachments
                        .count { it.attachmentType == AttachmentType.PHOTO }
                        .toString()
        holder?.tvRecordAttachmentsCount?.text =
                note.attachments
                        .count { it.attachmentType == AttachmentType.RECORD }
                        .toString()

        if (position == itemCount - 1)
            holder?.viewDivider?.visibility = View.GONE
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun setNotes(notes: MutableList<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    fun addNote(note: Note) {
        notes.add(0, note)
        notifyItemInserted(0)
    }

    fun removeNote(note: Note) {
        val removeIndex = notes.indexOf(note)
        notes.removeAt(removeIndex)
        notifyItemRemoved(removeIndex)
    }
}