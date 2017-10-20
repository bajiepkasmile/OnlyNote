package com.nodomain.onlynote.ui.fragments


import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.nodomain.onlynote.R
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.presenters.NoteDetailsMvpPresenter
import com.nodomain.onlynote.mvp.views.NoteDetailsMvpView
import com.nodomain.onlynote.navigation.NoteDetailsNavigator
import com.nodomain.onlynote.ui.dialogs.CancellationConfirmDialogFragment
import com.nodomain.onlynote.ui.dialogs.DeletionConfirmDialogFragment
import com.nodomain.onlynote.ui.listeners.CancellationDialogResultListener
import com.nodomain.onlynote.ui.listeners.DeletionDialogResultListener


class NoteDetailsFragment : BaseMvpFragment<NoteDetailsMvpView,
        NoteDetailsMvpPresenter>(), NoteDetailsMvpView,
        CancellationDialogResultListener, DeletionDialogResultListener {

    private val tvText: TextView = activity.findViewById(R.id.tv_text)
    private val fabAddAttachment: FloatingActionButton = activity.findViewById(R.id.fab_add_attachment)
    private val fabAddPhoto: FloatingActionButton = activity.findViewById(R.id.fab_add_photo)
    private val fabAddRecord: FloatingActionButton = activity.findViewById(R.id.fab_add_record)
    private val rvAttachments: RecyclerView = activity.findViewById(R.id.rv_attachments)

    var navigator: NoteDetailsNavigator? = null

    companion object {

        private const val ARG_NOTE = "note"

        fun newInstance(note: Note?): NoteDetailsFragment {
            val fragment = NoteDetailsFragment()

            val bundle = Bundle()
            bundle.putParcelable(ARG_NOTE, note)
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mvpPresenter?.attachMvpView(this)
    }

    override fun onDestroyView() {
        mvpPresenter?.detachMvpView()
        super.onDestroyView()
    }

    override fun showNote(note: Note) {
        tvText.text = note.text
    }

    override fun confirmCancellation() {
        val dialog = CancellationConfirmDialogFragment()
        dialog.show(activity.supportFragmentManager, "cancellation")
    }

    override fun confirmDeletion() {
        val dialog = DeletionConfirmDialogFragment()
        dialog.show(activity.supportFragmentManager, "deletion")
    }

    override fun showProgress() {
        tvText.isEnabled = false
        fabAddAttachment.isEnabled = false
        fabAddPhoto.isEnabled = false
        fabAddRecord.isEnabled = false
        rvAttachments.isEnabled = false
    }

    override fun navigateToPreviousView() {
        navigator?.navigateToPreviousView()
    }

    override fun onCancellationAccept() {
        mvpPresenter?.acceptChangesCancellation()
    }

    override fun onCancellationCancel() {
        mvpPresenter?.cancelChangesCancellation()
    }

    override fun onDeletionAccept() {
        mvpPresenter?.acceptNoteDeletion()
    }

    override fun onDeletionCancel() {
        mvpPresenter?.cancelNoteDeletion()
    }
}