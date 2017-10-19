package com.nodomain.onlynote.ui.fragments


import android.os.Bundle
import android.view.View
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.presenters.NoteListMvpPresenter
import com.nodomain.onlynote.mvp.views.NoteListMvpView
import com.nodomain.onlynote.navigation.NoteListNavigator


class NoteListFragment : BaseMvpFragment<NoteListMvpView, NoteListMvpPresenter>(), NoteListMvpView {

    var navigator: NoteListNavigator? = null

    companion object {

        fun newInstance(): NoteListFragment {
            return NoteListFragment()
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

    override fun showNotes(notes: List<Note>) {
        TODO("not implemented")
    }

    override fun navigateToNoteDetailsView(note: Note?) {
        navigator?.navigateToNoteDetailsView(note)
    }
}