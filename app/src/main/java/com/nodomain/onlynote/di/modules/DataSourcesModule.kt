package com.nodomain.onlynote.di.modules


import android.content.Context
import com.nodomain.onlynote.data.datasources.cache.Cache
import com.nodomain.onlynote.data.datasources.local.LocalStorage
import com.nodomain.onlynote.data.datasources.local.impl.DbHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataSourcesModule {

    @Provides
    @Singleton
    fun provideDbHelper(context: Context) = DbHelper(context)

    @Provides
    @Singleton
    fun provideLocalStorage(dbHelper: DbHelper) = LocalStorage(dbHelper)

    @Provides
    @Singleton
    fun provideCache() = Cache()
}