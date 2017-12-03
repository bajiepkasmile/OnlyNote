package com.nodomain.onlynote.presentation.mvp.presenterimpls


import com.nodomain.onlynote.presentation.mvp.presenters.MvpPresenter
import com.nodomain.onlynote.presentation.mvp.views.MvpView
import org.greenrobot.eventbus.EventBus


abstract class BaseMvpPresenterImpl<V : MvpView>(private val eventBus: EventBus) : MvpPresenter<V> {

    protected var mvpView: V? = null

    override fun attachMvpView(mvpView: V) {
        this.mvpView = mvpView
        eventBus.register(this)
    }

    override fun detachMvpView() {
        eventBus.unregister(this)
        mvpView = null
    }

    protected fun removeStickyEvent(event: Any?) = eventBus.removeStickyEvent(event)
}