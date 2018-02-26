package com.sidarau.socialko.di

import javax.inject.Scope

/**
 * @author Anton Sidorov
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope