package com.nodomain.onlynote.mvp.presenters


import com.nodomain.onlynote.mvp.views.MvpView


interface MvpPresenter<T : MvpView> {

    var mvpView: T
}