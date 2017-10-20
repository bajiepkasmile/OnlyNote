package com.nodomain.onlynote.ui.dialogs


import com.nodomain.onlynote.R
import com.nodomain.onlynote.ui.listeners.CancellationDialogResultListener


class CancellationConfirmDialogFragment : BaseConfirmDialogFragment<CancellationDialogResultListener>() {

    override val titleId: Int = R.string.dialog_title_confirm_cancellation
    override val messageId: Int = R.string.dialog_message_confirm_cancellation
    override val listenerClassQualifiedName: String? = CancellationDialogResultListener::class.qualifiedName

    override fun onAccept() {
        listener?.onCancellationAccept()
    }

    override fun onCancel() {
        listener?.onCancellationCancel()
    }
}
