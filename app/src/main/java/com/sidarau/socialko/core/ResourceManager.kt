package com.sidarau.socialko.core

import android.content.Context
import android.support.annotation.StringRes
import com.sidarau.socialko.di.AppContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Anton Sidorov
 */
@Singleton
class ResourceManager @Inject constructor(@AppContext private val context: Context) {

    fun getString(@StringRes resId: Int) = context.getString(resId)

}