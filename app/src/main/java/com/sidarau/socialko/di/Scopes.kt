package com.sidarau.socialko.di

import javax.inject.Scope

/**
 * @author Anton Sidorov
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SplashScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope