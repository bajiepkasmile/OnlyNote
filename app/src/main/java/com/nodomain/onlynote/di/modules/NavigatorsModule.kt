package com.nodomain.onlynote.di.modules


import com.nodomain.onlynote.navigation.MainNavigator
import com.nodomain.onlynote.navigation.NoteDetailsNavigator
import com.nodomain.onlynote.navigation.NoteListNavigator
import dagger.Module
import dagger.Provides


@Module
class NavigatorsModule {

    @Provides
    fun provideNoteListNavigator(mainNavigator: MainNavigator): NoteListNavigator = mainNavigator

    @Provides
    fun provideNoteDetailsNavigator(mainNavigator: MainNavigator): NoteDetailsNavigator = mainNavigator
}