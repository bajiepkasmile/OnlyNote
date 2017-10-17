package com.nodomain.onlynote.navigation


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.nodomain.onlynote.R
import com.nodomain.onlynote.model.Note
import com.nodomain.onlynote.ui.fragments.NoteDetailsFragment
import com.nodomain.onlynote.ui.fragments.NoteListFragment


class MainNavigator(private val fragmentManager: FragmentManager) : NoteListNavigator, NoteDetailsNavigator {

    override fun navigateToPreviousView() {
        if (fragmentManager.backStackEntryCount > 0)
            fragmentManager.popBackStack();
    }

    override fun navigateToNoteDetailsView(note: Note?) {
        replaceFragmentWithAddingToBackstack(NoteDetailsFragment.newInstance(note))
    }

    fun navigateToNoteList() {
        replaceFragment(NoteListFragment.newInstance())
    }

    private fun replaceFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.fl_fragment_container, fragment)
                .commit()
    }

    private fun replaceFragmentWithAddingToBackstack(fragment: Fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.fl_fragment_container, fragment)
                .addToBackStack(null)
                .commit()
    }
}