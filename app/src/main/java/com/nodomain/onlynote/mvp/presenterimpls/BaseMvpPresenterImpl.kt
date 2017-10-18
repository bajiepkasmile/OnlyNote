package com.nodomain.onlynote.mvp.presenterimpls


import com.nodomain.onlynote.mvp.presenters.MvpPresenter
import com.nodomain.onlynote.mvp.views.MvpView
import org.greenrobot.eventbus.EventBus


abstract class BaseMvpPresenterImpl<T : MvpView>(private val eventBus: EventBus) : MvpPresenter<T> {

    protected var mvpView: T? = null

    override fun attachMvpView(mvpView: T) {
        this.mvpView = mvpView
        eventBus.register(this)
    }

    override fun detachMvpView() {
        eventBus.unregister(this)
        mvpView = null
    }
}