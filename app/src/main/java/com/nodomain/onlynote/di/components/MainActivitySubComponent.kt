package com.nodomain.onlynote.di.components


import com.nodomain.onlynote.di.modules.MainActivityModule
import com.nodomain.onlynote.di.modules.NavigatorsModule
import com.nodomain.onlynote.di.modules.PresentersModule
import com.nodomain.onlynote.di.scopes.PerActivity
import com.nodomain.onlynote.presentation.ui.activities.MainActivity
import com.nodomain.onlynote.presentation.ui.fragments.NoteDetailsFragment
import com.nodomain.onlynote.presentation.ui.fragments.NoteListFragment
import dagger.Subcomponent


@PerActivity
@Subcomponent(
        modules = [MainActivityModule::class, NavigatorsModule::class, PresentersModule::class]
)
interface MainActivitySubComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: NoteListFragment)

    fun inject(fragment: NoteDetailsFragment)
}