package com.nodomain.onlynote.ui.recyclerviews.viewholders


import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.nodomain.onlynote.R
import kotterknife.bindView


class NoteViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    val tvText: TextView by bindView(R.id.tv_text)
    val tvCreatedTime: TextView by bindView(R.id.tv_created_time)
    val tvPhotoAttachmentsCount: TextView by bindView(R.id.tv_photo_attachments_count)
    val tvRecordAttachmentsCount: TextView by bindView(R.id.tv_record_attachments_count)
    val viewDivider: View by bindView(R.id.view_divider)
}