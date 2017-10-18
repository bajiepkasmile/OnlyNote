package com.nodomain.onlynote.mvp.presenters


import com.nodomain.onlynote.mvp.views.MvpView


interface MvpPresenter<T : MvpView> {

    fun attachMvpView(mvpView: T)

    fun detachMvpView()
}