package com.nodomain.onlynote.presentation.ui.dialogs


import com.nodomain.onlynote.R
import com.nodomain.onlynote.presentation.ui.listeners.DeletionDialogResultListener


class DeletionConfirmDialogFragment : BaseConfirmDialogFragment<DeletionDialogResultListener>() {

    override val titleId: Int = R.string.dialog_title_delete_empty_note
    override val messageId: Int = R.string.dialog_message_delete_empty_note

    override fun onAccept() {
        listener?.onDeletionAccept()
    }

    override fun onCancel() {
        listener?.onDeletionCancel()
    }
}