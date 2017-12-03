package com.nodomain.onlynote.di.modules


import com.nodomain.onlynote.data.datasources.local.LocalStorage
import data.datasources.local.impl.LocalStorageImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataSourcesModule {

    @Provides
    @Singleton
    fun provideLocalStorage(localStorageImpl: LocalStorageImpl): LocalStorage = localStorageImpl
}