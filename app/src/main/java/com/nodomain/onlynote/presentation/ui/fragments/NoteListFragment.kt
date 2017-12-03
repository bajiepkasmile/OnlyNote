package com.nodomain.onlynote.presentation.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nodomain.onlynote.R
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.presentation.mvp.presenters.NoteListMvpPresenter
import com.nodomain.onlynote.presentation.mvp.views.NoteListMvpView
import com.nodomain.onlynote.presentation.navigation.NoteListNavigator
import com.nodomain.onlynote.presentation.ui.activities.MainActivity
import com.nodomain.onlynote.presentation.ui.recyclerviews.adapters.NotesAdapter
import kotlinx.android.synthetic.main.fragment_note_list.*
import javax.inject.Inject


class NoteListFragment : BaseMvpFragment<NoteListMvpView, NoteListMvpPresenter>(), NoteListMvpView {

    private val NoteListFragment.mainActivity: MainActivity
        get() = activity as MainActivity

    private var notesAdapter: NotesAdapter? = null

    @Inject
    lateinit var navigator: NoteListNavigator

    companion object {

        fun newInstance(): NoteListFragment {
            return NoteListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mainActivity.mainActivitySubComponent.inject(this)
        return inflater?.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        mvpPresenter.getNotes()
    }

    override fun showNotes(notes: MutableList<Note>) {
        if (notesAdapter == null) {
            notesAdapter = NotesAdapter(notes)
            rv_notes.adapter = notesAdapter
        } else
            notesAdapter?.setNotes(notes)
    }

    override fun navigateToNoteDetailsView(note: Note?) {
        navigator.navigateToNoteDetailsView(note)
    }

    private fun setListeners() {
        fab_add_note.setOnClickListener { mvpPresenter.createNote() }
    }
}