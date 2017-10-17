package com.nodomain.onlynote.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import com.nodomain.onlynote.model.Note


class NoteDetailsFragment : Fragment() {

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
}