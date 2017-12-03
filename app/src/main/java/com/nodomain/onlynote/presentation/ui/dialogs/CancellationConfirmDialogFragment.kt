package com.nodomain.onlynote.presentation.ui.dialogs


import com.nodomain.onlynote.R
import com.nodomain.onlynote.presentation.ui.listeners.CancellationDialogResultListener


class CancellationConfirmDialogFragment : BaseConfirmDialogFragment<CancellationDialogResultListener>() {

    override val titleId: Int = R.string.dialog_title_confirm_cancellation
    override val messageId: Int = R.string.dialog_message_confirm_cancellation

    override fun onAccept() {
        listener?.onCancellationAccept()
    }

    override fun onCancel() {
        listener?.onCancellationCancel()
    }
}
