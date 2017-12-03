package com.nodomain.onlynote.presentation.mvp.presenters


import com.nodomain.onlynote.presentation.mvp.views.MvpView


interface MvpPresenter<in V : MvpView> {

    fun attachMvpView(mvpView: V)

    fun detachMvpView()
}