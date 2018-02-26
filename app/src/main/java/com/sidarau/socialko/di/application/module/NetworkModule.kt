package com.sidarau.socialko.di.application.module

import com.sidarau.socialko.BuildConfig
import com.sidarau.socialko.data.network.SocialkoApi
import com.sidarau.socialko.data.network.auth.AuthorizationInterceptor
import com.sidarau.socialko.di.ServerPath
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author Anton Sidorov
 */
@Module
abstract class NetworkModule {

    @Singleton
    @Binds
    abstract fun providerAuthIntercepter(authInterceptor: AuthorizationInterceptor): Interceptor

    @Module
    companion object {

        @Singleton
        @Provides
        @ServerPath
        @JvmStatic
        fun providerServerPath() = "https://socialko.cfapps.io/api/"

        @Singleton
        @Provides
        @JvmStatic
        fun provideHttpClient(authInterceptor: Interceptor): OkHttpClient {
            //FIXME interceptors of error responses???
            val httpClientBuilder = OkHttpClient.Builder()
            httpClientBuilder.readTimeout(20, TimeUnit.SECONDS)
            httpClientBuilder.addNetworkInterceptor(authInterceptor)

            if (BuildConfig.DEBUG) {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                httpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor)
            }

            return httpClientBuilder.build()
        }

        @Singleton
        @Provides
        @JvmStatic
        fun provideSocialkoApi(retrofit: Retrofit): SocialkoApi =
                retrofit.create(SocialkoApi::class.java)

        @Singleton
        @Provides
        @JvmStatic
        fun provideRetrofit(
                @ServerPath baseUrl: String,
                okHttpClient: OkHttpClient
        ): Retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .build()
    }
}