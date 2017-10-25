package com.nodomain.onlynote.di.modules


import com.nodomain.onlynote.data.datasources.cache.Cache
import com.nodomain.onlynote.data.datasources.local.LocalStorage
import data.datasources.local.LocalStorageImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataSourcesModule {

    @Provides
    @Singleton
    fun provideLocalStorage(localStorageImpl: LocalStorageImpl): LocalStorage = localStorageImpl

    @Provides
    @Singleton
    fun provideCache() = Cache()
}