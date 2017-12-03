package com.nodomain.onlynote.presentation.ui.dialogs


import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import com.nodomain.onlynote.R


abstract class BaseConfirmDialogFragment<L> : DialogFragment() {

    protected abstract val titleId: Int
    protected abstract val messageId: Int

    protected var listener: L? = null

    abstract fun onAccept()

    abstract fun onCancel()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        builder
                .setTitle(titleId)
                .setMessage(messageId)
                .setPositiveButton(R.string.ok, { _, _ -> onAccept() } )
                .setNegativeButton(R.string.cancel, { _, _ -> onCancel() })

        return builder.create()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        try {
            listener = parentFragment as L
        } catch (e: ClassCastException) {
            throw ClassCastException(parentFragment.toString()
                    + " does not implement the required listener interface")
        }
    }
}