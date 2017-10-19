package com.nodomain.onlynote.mvp.presenters


import com.nodomain.onlynote.mvp.views.MvpView


interface MvpPresenter<in V : MvpView> {

    fun attachMvpView(mvpView: V)

    fun detachMvpView()
}