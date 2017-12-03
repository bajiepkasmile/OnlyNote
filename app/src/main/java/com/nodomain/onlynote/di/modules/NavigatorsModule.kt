package com.nodomain.onlynote.di.modules


import com.nodomain.onlynote.presentation.navigation.MainNavigator
import com.nodomain.onlynote.presentation.navigation.NoteDetailsNavigator
import com.nodomain.onlynote.presentation.navigation.NoteListNavigator
import dagger.Module
import dagger.Provides


@Module
class NavigatorsModule {

    @Provides
    fun provideNoteListNavigator(mainNavigator: MainNavigator): NoteListNavigator = mainNavigator

    @Provides
    fun provideNoteDetailsNavigator(mainNavigator: MainNavigator): NoteDetailsNavigator = mainNavigator
}