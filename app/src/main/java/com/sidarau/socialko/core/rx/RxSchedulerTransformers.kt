package com.sidarau.socialko.core.rx

import io.reactivex.*

/**
 * @author Anton Sidorov
 */
interface RxSchedulerTransformers {

    fun <T> ioToUiTransformer(): ObservableTransformer<T, T>

    fun ioToUiTransformerCompletable(): CompletableTransformer

    fun <T> ioToUiTransformerMaybe(): MaybeTransformer<T, T>

    fun <T> ioToUiTransformerSingle(): SingleTransformer<T, T>

    fun <T> ioToUiTransformerFlowable(): FlowableTransformer<T, T>

    fun <T> computationToUiTransformer(): ObservableTransformer<T, T>

    fun <T> computationToUiTransformerSingle(): SingleTransformer<T, T>
}