package com.nodomain.onlynote.di.modules


import com.nodomain.onlynote.di.scopes.PerActivity
import com.nodomain.onlynote.presentation.navigation.MainNavigator
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule(private val mainNavigator: MainNavigator) {

    @Provides
    @PerActivity
    fun provideMainNavigator() = mainNavigator
}