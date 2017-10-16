package com.nodomain.onlynote.domain.interactors


import android.os.Handler
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.ExecutorService


abstract class BaseInteractor<A> protected constructor(
        private val executorService: ExecutorService,
        private val mainThreadHandler: Handler,
        private val eventBus: EventBus) {

    abstract fun execute(args: A)

    protected fun inBackground(backgroundFun: () -> Unit) = executorService.execute(backgroundFun)

    protected fun onMainThread(mainThreadFun: () -> Unit) = mainThreadHandler.post(mainThreadFun)

    protected fun postStickyEvent(event: Any) = eventBus.postSticky(event)
}