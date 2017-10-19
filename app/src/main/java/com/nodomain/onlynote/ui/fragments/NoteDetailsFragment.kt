package com.nodomain.onlynote.ui.fragments


import android.os.Bundle
import android.view.View
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.presenters.NoteDetailsMvpPresenter
import com.nodomain.onlynote.mvp.views.NoteDetailsMvpView


class NoteDetailsFragment : BaseMvpFragment<NoteDetailsMvpView, NoteDetailsMvpPresenter>(), NoteDetailsMvpView {

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

    override fun navigateToPreviousView() {
        TODO("not implemented")
    }

    override fun showNote(note: Note) {
        TODO("not implemented")
    }

    override fun confirmCancellation() {
        TODO("not implemented")
    }

    override fun confirmDeletion() {
        TODO("not implemented")
    }

    override fun showProgress() {
        TODO("not implemented")
    }
}