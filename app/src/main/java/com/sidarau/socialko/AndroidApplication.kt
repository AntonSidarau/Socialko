package com.sidarau.socialko

import android.app.Activity
import android.app.Application
import com.sidarau.socialko.di.application.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
class AndroidApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    private fun initDagger() = DaggerAppComponent
            .builder()
            .create(this)
            .inject(this)
}