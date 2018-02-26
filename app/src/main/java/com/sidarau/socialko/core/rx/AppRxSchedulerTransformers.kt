package com.sidarau.socialko.core.rx

import io.reactivex.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Anton Sidorov
 */
@Singleton
class AppRxSchedulerTransformers @Inject constructor(
        private val schedulers: SchedulersProvider
) : RxSchedulerTransformers {

    override fun <T> ioToUiTransformer(): ObservableTransformer<T, T> =
            ObservableTransformer {
                it.subscribeOn(schedulers.io()).observeOn(schedulers.ui())
            }

    override fun ioToUiTransformerCompletable(): CompletableTransformer =
            CompletableTransformer {
                it.subscribeOn(schedulers.io()).observeOn(schedulers.ui())
            }

    override fun <T> ioToUiTransformerMaybe(): MaybeTransformer<T, T> =
            MaybeTransformer {
                it.subscribeOn(schedulers.io()).observeOn(schedulers.ui())
            }

    override fun <T> ioToUiTransformerSingle(): SingleTransformer<T, T> =
            SingleTransformer {
                it.subscribeOn(schedulers.io()).observeOn(schedulers.ui())
            }

    override fun <T> ioToUiTransformerFlowable(): FlowableTransformer<T, T> =
            FlowableTransformer {
                it.subscribeOn(schedulers.io()).observeOn(schedulers.ui())
            }

    override fun <T> computationToUiTransformer(): ObservableTransformer<T, T> =
            ObservableTransformer {
                it.subscribeOn(schedulers.computation()).observeOn(schedulers.ui())
            }

    override fun <T> computationToUiTransformerSingle(): SingleTransformer<T, T> =
            SingleTransformer {
                it.subscribeOn(schedulers.computation()).observeOn(schedulers.ui())
            }
}