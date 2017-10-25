package com.nodomain.onlynote.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.nodomain.onlynote.mvp.presenters.MvpPresenter
import com.nodomain.onlynote.mvp.views.MvpView
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject


abstract class BaseMvpFragment<in V : MvpView, P : MvpPresenter<V>> : Fragment(), MvpView {

    @Inject
    protected lateinit var mvpPresenter: P
    @Inject
    lateinit var eventBus: EventBus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventBus.register(this)
    }

    override fun onDestroyView() {
        eventBus.unregister(this)
        super.onDestroyView()
    }
}