package com.nodomain.onlynote.ui.recyclerviews.viewholders


import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.nodomain.onlynote.R


class NoteViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    val tvText: TextView? = itemView?.findViewById(R.id.tv_text)
    val tvCreatedTime: TextView? = itemView?.findViewById(R.id.tv_created_time)
    val tvPhotoAttachmentsCount: TextView? = itemView?.findViewById(R.id.tv_photo_attachments_count)
    val tvRecordAttachmentsCount: TextView? = itemView?.findViewById(R.id.tv_record_attachments_count)
    val viewDivider: View? = itemView?.findViewById(R.id.view_divider)
}