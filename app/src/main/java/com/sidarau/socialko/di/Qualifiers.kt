package com.sidarau.socialko.di

import javax.inject.Qualifier

/**
 * @author Anton Sidorov
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ServerPath