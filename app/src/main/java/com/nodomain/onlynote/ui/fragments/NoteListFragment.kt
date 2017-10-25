package com.nodomain.onlynote.ui.fragments


import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nodomain.onlynote.R
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.mvp.presenters.NoteListMvpPresenter
import com.nodomain.onlynote.mvp.views.NoteListMvpView
import com.nodomain.onlynote.navigation.NoteListNavigator
import com.nodomain.onlynote.ui.activities.MainActivity
import com.nodomain.onlynote.ui.recyclerviews.adapters.NotesAdapter


class NoteListFragment : BaseMvpFragment<NoteListMvpView, NoteListMvpPresenter>(), NoteListMvpView {

    private val NoteListFragment.mainActivity: MainActivity
        get() = activity as MainActivity

    private var rvNotes: RecyclerView? = null// = activity.findViewById(R.id.rv_notes)
    private var fabAddNote: FloatingActionButton? = null// = activity.findViewById(R.id.fab_add_note)

    private var notesAdapter: NotesAdapter? = null

    var navigator: NoteListNavigator? = null

    companion object {

        fun newInstance(): NoteListFragment {
            return NoteListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mainActivity.mainActivitySubComponent.inject(this)
        return inflater?.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun showNotes(notes: MutableList<Note>) {
        if (notesAdapter == null) {
            notesAdapter = NotesAdapter(notes)
            rvNotes?.adapter = notesAdapter
        } else
            notesAdapter?.setNotes(notes)
    }

    override fun navigateToNoteDetailsView(note: Note?) {
        navigator?.navigateToNoteDetailsView(note)
    }
}