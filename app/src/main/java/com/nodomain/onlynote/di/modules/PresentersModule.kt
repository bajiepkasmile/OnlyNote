package com.nodomain.onlynote.di.modules


import com.nodomain.onlynote.presentation.mvp.presenterimpls.NoteDetailsMvpPresenterImpl
import com.nodomain.onlynote.presentation.mvp.presenterimpls.NoteListMvpPresenterImpl
import com.nodomain.onlynote.presentation.mvp.presenters.NoteDetailsMvpPresenter
import com.nodomain.onlynote.presentation.mvp.presenters.NoteListMvpPresenter
import dagger.Module
import dagger.Provides


@Module
class PresentersModule {

    @Provides
    fun provideNoteListPresenter(presenterImpl: NoteListMvpPresenterImpl): NoteListMvpPresenter = presenterImpl

    @Provides
    fun provideNoteDetailsPresenter(presenterImpl: NoteDetailsMvpPresenterImpl): NoteDetailsMvpPresenter
            = presenterImpl
}