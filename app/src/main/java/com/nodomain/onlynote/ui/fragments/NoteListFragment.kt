package com.nodomain.onlynote.ui.fragments


import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.RecyclerView
import android.view.View
import com.nodomain.onlynote.R
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.presenters.NoteListMvpPresenter
import com.nodomain.onlynote.mvp.views.NoteListMvpView
import com.nodomain.onlynote.navigation.NoteListNavigator
import com.nodomain.onlynote.ui.recyclerviews.adapters.NotesAdapter


class NoteListFragment : BaseMvpFragment<NoteListMvpView, NoteListMvpPresenter>(), NoteListMvpView {

    private val rvNotes: RecyclerView = activity.findViewById(R.id.rv_notes)
    private val fabAddNote: FloatingActionButton = activity.findViewById(R.id.fab_add_note)

    private var notesAdapter: NotesAdapter? = null

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

    override fun showNotes(notes: MutableList<Note>) {
        if (notesAdapter == null) {
            notesAdapter = NotesAdapter(notes)
            rvNotes.adapter = notesAdapter
        } else
            notesAdapter?.setNotes(notes)
    }

    override fun navigateToNoteDetailsView(note: Note?) {
        navigator?.navigateToNoteDetailsView(note)
    }
}